/**
 * 
 */
package br.com.siar.controllers;

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

import br.com.siar.models.MissaoSiar;
import br.com.siar.models.StatusMissao;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.services.AcidenteSiarService;
import br.com.siar.services.MissaoSiarService;
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
		
		if (missao.getStatus() == null) missao.setStatus(StatusMissao.PENDENTE);
		
		missaoService.saveMissao(missao);
		return new RedirectView(Const.SIAR + MISSOES);
	}
	
	@RequestMapping(value = MISSOES + Const.DELETE, method = RequestMethod.GET)
	public View removeMissao(HttpServletRequest request, @PathVariable String id, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.ESPECIALISTA))
			return new RedirectView(Const.HOME_ADDRESS);
		
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

		model.addAttribute(Const.ATTR_TITLE, "Criar missão");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_MISSOES.getPath());
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
