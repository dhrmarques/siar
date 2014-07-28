/**
 * 
 */
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

import br.com.siar.models.RecursoSiar;
import br.com.siar.models.UsuarioSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.services.RecursoSiarService;
import br.com.siar.utils.Const;
import br.com.siar.utils.SessionHelper;

/**
 * @author Leo
 *
 */
@Controller
public class RecursoSiarController {
	
	@Autowired
	private RecursoSiarService recursoService;
	
	@RequestMapping(value = "/recursos", method = RequestMethod.GET)
	public String getRecursosList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request, model))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Recursos");
		model.addAttribute("recursoSiarList", recursoService.listRecursos());
		return "recursosiar";
	}
	
	@RequestMapping(value = "/recursos/save", method = RequestMethod.POST)
	public View saveRecurso(HttpServletRequest request, @ModelAttribute RecursoSiar recurso, ModelMap model) {
		if (!autorizado(request, model))
			return new RedirectView(Const.HOME_ADDRESS);
		
		recursoService.saveRecurso(recurso);
		return new RedirectView("/siar/recursos");
	}
	
	@RequestMapping(value = "/recursos/delete/{id}", method = RequestMethod.GET)
	public View removeRecurso(HttpServletRequest request, @PathVariable String id, ModelMap model) {
		if (!autorizado(request, model))
			return new RedirectView(Const.HOME_ADDRESS);
		
		recursoService.removeRecurso(id);
		return new RedirectView("/siar/recursos");
	}
	
	@RequestMapping(value = "/recursos/update/{id}", method = RequestMethod.GET)
	public String updateRecurso(HttpServletRequest request, @PathVariable String id, ModelMap model){
		if (!autorizado(request, model))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Editar recurso");
		model.addAttribute("recursoUpdate", recursoService.findRecursoById(id));
		return "updaterecurso";
	}
	
	private boolean autorizado(HttpServletRequest request, ModelMap model) {
		
		TipoUsuario tipo = TipoUsuario.ADMINISTRADOR;
		
		UsuarioSiar usuario = SessionHelper.getUsuarioLogado(request);
		if (usuario != null && usuario.getTipoUsuario().equals(tipo)) {
			
			model.addAttribute(Const.ATTR_NAME, usuario.getNome());
			model.addAttribute(Const.ATTR_USER_TYPE, tipo.desc);
			
			return true;
		}
		return false;
	}

}
