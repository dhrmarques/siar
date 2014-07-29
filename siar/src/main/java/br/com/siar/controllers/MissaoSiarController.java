/**
 * 
 */
package br.com.siar.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.servlet.view.RedirectView;

import br.com.siar.models.AcidenteSiar;
import br.com.siar.models.MissaoSiar;
import br.com.siar.models.TipoMissaoSiar;
import br.com.siar.models.UsuarioSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.models.response.MissaoResponse;
import br.com.siar.services.AcidenteSiarService;
import br.com.siar.services.MissaoSiarService;
import br.com.siar.services.TipoMissaoSiarService;
import br.com.siar.utils.Const;
import br.com.siar.utils.SessionHelper;

/**
 * @author Leo
 *
 */
@Controller
public class MissaoSiarController implements ApplicationContextAware {

	@Autowired
	private MissaoSiarService missaoService;
	
	private AcidenteSiarService getAcidenteService() {
		return appContext.getBean(AcidenteSiarService.class);
	}
	private TipoMissaoSiarService getTipoMissaoService() {
		return appContext.getBean(TipoMissaoSiarService.class);
	}
	
	@RequestMapping(value = "/missoes", method = RequestMethod.GET)
	public String getMissoesList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request, model))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Missões");
		List<MissaoSiar> missoes = missaoService.listMissoes();
		List<MissaoResponse> list = new ArrayList<MissaoResponse>();
		
		AcidenteSiarService acidenteService = getAcidenteService();
		TipoMissaoSiarService tipoMissaoService = getTipoMissaoService();
		
		for (MissaoSiar missao : missoes) {
			AcidenteSiar acidente = acidenteService.findAcidenteById(missao.getAcidenteId());
			TipoMissaoSiar tipoMissao = tipoMissaoService.findTipoMissaoById(missao.getTipoMissaoId());
			list.add(new MissaoResponse(missao, acidente, tipoMissao, "status?"));
		}
		
		model.addAttribute("responseList", list);
		return "missaosiar";
	}
	
	@RequestMapping(value = "/missoes/save", method = RequestMethod.POST)
	public View saveMissao(HttpServletRequest request, @ModelAttribute MissaoSiar missao, ModelMap model) {
		if (!autorizado(request, model))
			return new RedirectView(Const.HOME_ADDRESS);
		
		missaoService.saveMissao(missao);
		return new RedirectView("/siar/missoes");
	}
	
	@RequestMapping(value = "/missoes/delete/{id}", method = RequestMethod.GET)
	public View removeMissao(HttpServletRequest request, @PathVariable String id, ModelMap model) {
		if (!autorizado(request, model))
			return new RedirectView(Const.HOME_ADDRESS);
		
		missaoService.removeMissao(id);
		return new RedirectView("/siar/missoes");
	}
	
	@RequestMapping(value = "/missoes/new", method = RequestMethod.POST)
	public String createMissao(HttpServletRequest request, ModelMap model){
		if (!autorizado(request, model))
			return Const.REDIRECT_UNAUTHORIZED;
		
		String acidenteId = request.getParameter("acidenteId").toString();
		
		model.addAttribute(Const.ATTR_TITLE, "Criar missão");
		model.addAttribute("acidente", getAcidenteService().findAcidenteById(acidenteId));
		model.addAttribute("tiposMissao", getTipoMissaoService().listTiposMissao());
		return "createmissao";
	}
	
	@RequestMapping(value = "/missoes/update/{id}", method = RequestMethod.GET)
	public String updateMissao(HttpServletRequest request, @PathVariable String id, ModelMap model){
		if (!autorizado(request, model))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Editar missão");
		
		MissaoSiar missao = missaoService.findMissaoById(id);
		MissaoResponse response = new MissaoResponse(missao,
				getAcidenteService().findAcidenteById(missao.getAcidenteId()),
				getTipoMissaoService().findTipoMissaoById(missao.getTipoMissaoId()),
				"Status...");
		
		model.addAttribute("missaoResponse", response);
		return "updatemissao";
	}
	
	private boolean autorizado(HttpServletRequest request, ModelMap model) {
		
		TipoUsuario tipo = TipoUsuario.ESPECIALISTA;
		
		UsuarioSiar usuario = SessionHelper.getUsuarioLogado(request);
		if (usuario != null && usuario.getTipoUsuario().equals(tipo)) {
			
			model.addAttribute(Const.ATTR_NAME, usuario.getNome());
			model.addAttribute(Const.ATTR_USER_TYPE, tipo.desc);
			
			return true;
		}
		return false;
	}

	protected ApplicationContext appContext;
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;
	}
}
