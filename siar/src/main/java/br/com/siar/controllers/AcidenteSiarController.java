package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import br.com.siar.models.AcidenteSiar;
import br.com.siar.models.UsuarioSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.services.AcidenteSiarService;
import br.com.siar.utils.Const;
import br.com.siar.utils.SessionHelper;

@Controller
public class AcidenteSiarController {

	@Autowired
	private AcidenteSiarService acidenteSiarService;
	
	@RequestMapping(value = "/acidentesiar", method = RequestMethod.GET)
	public String getAcidentesList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request, model))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Acidentes");
		model.addAttribute("acidenteSiarList", acidenteSiarService.listAcidentes());
		return "acidentesiar";
	}
	
	@RequestMapping(value = "/acidentes", method = RequestMethod.GET)
	public String getActiveAcidentesList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.ESPECIALISTA))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Acidentes em aberto");
		model.addAttribute("acidenteList", acidenteSiarService.listActiveAcidentes());
		return "acidentemissao";
	}
	
	@RequestMapping(value = "/acidentesiar/save", method = RequestMethod.POST)
	public View saveAcidente(HttpServletRequest request, @ModelAttribute AcidenteSiar acidenteSiar, ModelMap model) {
		if (!autorizado(request, model))
			return new RedirectView(Const.HOME_ADDRESS);
		
		acidenteSiarService.saveAcidente(acidenteSiar);
		return new RedirectView("/siar/acidentesiar");
	}
	
	@RequestMapping(value = "/acidentesiar/delete/{id}", method = RequestMethod.GET)
	public View removeAcidente(HttpServletRequest request, @PathVariable String id, ModelMap model) {
		if (!autorizado(request, model))
			return new RedirectView(Const.HOME_ADDRESS);
		
		acidenteSiarService.removeAcidente(id);
		return new RedirectView("/siar/acidentesiar");
	}
	
	@RequestMapping(value = "/acidentesiar/updateacidente/{id}", method = RequestMethod.GET)
	public String updateAcidente(HttpServletRequest request, @PathVariable String id, ModelMap model){
		if (!autorizado(request, model))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Editar acidente");
		model.addAttribute("acidenteUpdate", acidenteSiarService.findAcidenteById(id));
		return "updateacidente";
	}
	
	private boolean autorizado(HttpServletRequest request, ModelMap model) {
		
		return autorizado(request, model, TipoUsuario.COORDENADOR);
	}
	
	private boolean autorizado(HttpServletRequest request, ModelMap model, TipoUsuario tipoUser) {
		
		UsuarioSiar usuario = SessionHelper.getUsuarioLogado(request);
		if (usuario != null && usuario.getTipoUsuario().equals(tipoUser)) {
			
			model.addAttribute(Const.ATTR_NAME, usuario.getNome());
			model.addAttribute(Const.ATTR_USER_TYPE, tipoUser.desc);
			
			return true;
		}
		return false;
	}
}
