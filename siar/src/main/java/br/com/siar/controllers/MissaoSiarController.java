/**
 * 
 */
package br.com.siar.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bson.types.ObjectId;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.siar.models.MissaoSiar;
import br.com.siar.models.NecessidadeRecursoSiar;
import br.com.siar.models.StatusMissao;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.models.response.MissaoResponse;
import br.com.siar.services.AcidenteSiarService;
import br.com.siar.services.MissaoSiarService;
import br.com.siar.services.NecessidadeRecursoService;
import br.com.siar.services.RecursoSiarService;
import br.com.siar.services.TipoMissaoSiarService;
import br.com.siar.utils.Const;

/**
 * @author Leo
 *
 */
@Controller
public class MissaoSiarController extends BasicController implements ApplicationContextAware {

	@Autowired
	private MissaoSiarService missaoService;
	
	private AcidenteSiarService getAcidenteService() {
		return appContext.getBean(AcidenteSiarService.class);
	}
	private TipoMissaoSiarService getTipoMissaoService() {
		return appContext.getBean(TipoMissaoSiarService.class);
	}
	private RecursoSiarService getRecursoService() {
		return appContext.getBean(RecursoSiarService.class);
	}
	private NecessidadeRecursoService getNecessidadeRecursoService() {
		return appContext.getBean(NecessidadeRecursoService.class);
	}
	
	@RequestMapping(value = MISSOES, method = RequestMethod.GET)
	public String getMissoesList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.ESPECIALISTA))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute("responseList", missaoService.listMissoes());
		
		model.addAttribute(Const.ATTR_TITLE, "Missões");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_MISSOES.getPath());
		return "missaosiar";
	}
	
	@RequestMapping(value = MISSOES + Const.SAVE, method = RequestMethod.POST)
	public View saveMissao(HttpServletRequest request, @ModelAttribute MissaoSiar missao, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.ESPECIALISTA))
			return new RedirectView(Const.HOME_ADDRESS);
		
		boolean criando = false;
		if (missao.getStatus() == null) {
			missao.setStatus(StatusMissao.PENDENTE);
			criando = true;
		}
		else if (!missao.getStatus().equals(StatusMissao.PENDENTE))
			return new RedirectView(Const.HOME_ADDRESS); // TODO: mensagem de erro (Não pode mais alterar)
			
		ObjectId missaoId = missaoService.saveMissao(missao);
		
		if (criando) {
			List<NecessidadeRecursoSiar> necessidades = new ArrayList<NecessidadeRecursoSiar>();
			String[] idRecursos = request.getParameterValues("recursoId");
			String[] quantidades = request.getParameterValues("quantidade");
			for (int i = 0 ; i < idRecursos.length ; i++) {
				NecessidadeRecursoSiar nrs = new NecessidadeRecursoSiar();
				nrs.setRecursoId(new ObjectId(idRecursos[i]));
				nrs.setMissaoId(missaoId);
				nrs.setQuantidadeTotal(Integer.parseInt(quantidades[i]));
				nrs.setId(new ObjectId());
				necessidades.add(nrs);
			}
			
			getNecessidadeRecursoService().saveNecessidades(necessidades);
		}else{
			MissaoResponse m = missaoService.findMissaoById(missao.getId().toString());
			m.setDetalhes(missao.getDetalhes());
			missaoService.saveMissao(m.getMissao());
		}
		
		return new RedirectView(Const.SIAR + MISSOES);
	}
	
	@RequestMapping(value = MISSOES + Const.DELETE, method = RequestMethod.GET)
	public View removeMissao(HttpServletRequest request, @PathVariable String id, ModelMap model, final RedirectAttributes redirectAttributes) {
		if (!autorizado(request, model, TipoUsuario.ESPECIALISTA))
			return new RedirectView(Const.HOME_ADDRESS);
		redirectAttributes.addFlashAttribute("cls", Const.CSS_SUCCESS_CLASS);
		redirectAttributes.addFlashAttribute("box_text", MissaoSiar.class.getSimpleName() + Const.DELETED);
		missaoService.removeMissao(id);
		return new RedirectView(Const.SIAR + MISSOES);
	}
	
	@RequestMapping(value = MISSOES + Const.NEW, method = RequestMethod.POST)
	public String createMissao(HttpServletRequest request, ModelMap model){
		if (!autorizado(request, model, TipoUsuario.ESPECIALISTA))
			return Const.REDIRECT_UNAUTHORIZED;
		
		String acidenteId = request.getParameter("acidenteId").toString();
		
		model.addAttribute("acidente", getAcidenteService().findAcidenteById(acidenteId));
		model.addAttribute("tiposMissao", getTipoMissaoService().listTiposMissao());
		model.addAttribute("recursos", getRecursoService().listRecursos());

		model.addAttribute(Const.ATTR_TITLE, "Criar missão");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_EMERGENCIAS.getPath());
		return "createmissao";
	}
	
	@RequestMapping(value = MISSOES + Const.UPDATE, method = RequestMethod.GET)
	public String updateMissao(HttpServletRequest request, @PathVariable String id, ModelMap model){
		if (!autorizado(request, model, TipoUsuario.ESPECIALISTA))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute("missaoResponse", missaoService.findMissaoById(id));

		model.addAttribute(Const.ATTR_TITLE, "Editar missão");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_MISSOES.getPath());
		return "updatemissao";
	}

	protected ApplicationContext appContext;
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;
	}
}
