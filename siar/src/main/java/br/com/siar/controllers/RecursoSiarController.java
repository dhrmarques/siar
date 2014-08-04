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
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.services.RecursoSiarService;
import br.com.siar.utils.Const;

/**
 * @author Leo
 *
 */
@Controller
public class RecursoSiarController extends BasicController {
	
	@Autowired
	private RecursoSiarService recursoService;
	
	@RequestMapping(value = RECURSOS, method = RequestMethod.GET)
	public String getRecursosList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.ADMINISTRADOR))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute("recursoSiarList", recursoService.listRecursos());

		model.addAttribute(Const.ATTR_TITLE, "Recursos");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_RECURSOS.getPath());
		return "recursosiar";
	}
	
	@RequestMapping(value = RECURSOS + Const.SAVE, method = RequestMethod.POST)
	public View saveRecurso(HttpServletRequest request, @ModelAttribute RecursoSiar recurso, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.ADMINISTRADOR))
			return new RedirectView(Const.HOME_ADDRESS);
		
		recursoService.saveRecurso(recurso);
		return new RedirectView("/siar/recursos");
	}
	
	@RequestMapping(value = RECURSOS + Const.DELETE, method = RequestMethod.GET)
	public View removeRecurso(HttpServletRequest request, @PathVariable String id, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.ADMINISTRADOR))
			return new RedirectView(Const.HOME_ADDRESS);
		
		recursoService.removeRecurso(id);
		return new RedirectView("/siar/recursos");
	}
	
	@RequestMapping(value = RECURSOS + Const.UPDATE, method = RequestMethod.GET)
	public String updateRecurso(HttpServletRequest request, @PathVariable String id, ModelMap model){
		if (!autorizado(request, model, TipoUsuario.ADMINISTRADOR))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute("recursoUpdate", recursoService.findRecursoById(id));

		model.addAttribute(Const.ATTR_TITLE, "Editar recurso");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_RECURSOS.getPath());
		return "updaterecurso";
	}
}
