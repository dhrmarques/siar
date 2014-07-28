/**
 * 
 */
package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import br.com.siar.models.MissaoSiar;
import br.com.siar.models.UsuarioSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.services.MissaoSiarService;
import br.com.siar.utils.Const;
import br.com.siar.utils.SessionHelper;

/**
 * @author Leo
 *
 */
public class MissaoSiarController {

	@Autowired
	private MissaoSiarService service;
	
	@RequestMapping(value = "/missoes", method = RequestMethod.GET)
	public String getMissoesList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request, model))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Missões");
		model.addAttribute("missaoSiarList", service.listMissoes());
		return "missaoosiar";
	}
	
	@RequestMapping(value = "/missoes/save", method = RequestMethod.POST)
	public View saveMissao(HttpServletRequest request, @ModelAttribute MissaoSiar missao, ModelMap model) {
		if (!autorizado(request, model))
			return new RedirectView(Const.HOME_ADDRESS);
		
		service.saveMissao(missao);
		return new RedirectView("/siar/missoes");
	}
	
	@RequestMapping(value = "/missoes/delete/{id}", method = RequestMethod.GET)
	public View removeMissao(HttpServletRequest request, @PathVariable String id, ModelMap model) {
		if (!autorizado(request, model))
			return new RedirectView(Const.HOME_ADDRESS);
		
		service.removeMissao(id);
		return new RedirectView("/siar/missoes");
	}
	
	@RequestMapping(value = "/missoes/update/{id}", method = RequestMethod.GET)
	public String updateMissao(HttpServletRequest request, @PathVariable String id, ModelMap model){
		if (!autorizado(request, model))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Editar missão");
		model.addAttribute("missaoUpdate", service.findMissaoById(id));
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
}
