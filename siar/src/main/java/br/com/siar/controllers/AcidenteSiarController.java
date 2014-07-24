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
import br.com.siar.services.AcidenteSiarService;
import br.com.siar.utils.Constants;
import br.com.siar.utils.SessionHelper;

@Controller
public class AcidenteSiarController {

	@Autowired
	private AcidenteSiarService acidenteSiarService;
	
	@RequestMapping(value = "/acidentesiar", method = RequestMethod.GET)
	public String getAcidentesList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request))
			return Constants.REDIRECT_UNAUTHORIZED;
		model.addAttribute("acidenteSiarList", acidenteSiarService.listAcidentes());
		return "acidentesiar";
	}
	
	@RequestMapping(value = "/acidentesiar/save", method = RequestMethod.POST)
	public View saveAcidente(HttpServletRequest request, @ModelAttribute AcidenteSiar acidenteSiar, ModelMap model) {
		if (!autorizado(request))
			return new RedirectView("/");
		acidenteSiarService.saveAcidente(acidenteSiar);
		return new RedirectView("/siar/acidentesiar");
	}
	
	@RequestMapping(value = "/acidentesiar/delete/{id}", method = RequestMethod.GET)
	public View removeAcidente(HttpServletRequest request, @PathVariable String id, ModelMap model) {
		if (!autorizado(request))
			return new RedirectView("/");
		acidenteSiarService.removeAcidente(id);
		return new RedirectView("/siar/acidentesiar");
	}
	
	@RequestMapping(value = "/acidentesiar/updateacidente/{id}", method = RequestMethod.GET)
	public String updateAcidente(HttpServletRequest request, @PathVariable String id, ModelMap model){
		if (!autorizado(request))
			return Constants.REDIRECT_UNAUTHORIZED;
		model.addAttribute("acidenteUpdate", acidenteSiarService.findAcidenteById(id));
		return "updateacidente";
	}
	
	private boolean autorizado(HttpServletRequest request) {
		
		return SessionHelper.isUsuarioLogadoTipo(request, UsuarioSiar.TipoUsuario.COORDENADOR);
	}
}
