package br.com.siar.controllers;

import java.util.Arrays;

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
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.services.AcidenteSiarService;
import br.com.siar.utils.Const;

@Controller
public class AcidenteSiarController extends BasicController {

	@Autowired
	private AcidenteSiarService acidenteSiarService;
	
	@RequestMapping(value = ACIDENTES, method = RequestMethod.GET)
	public String getAcidentesList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.COORDENADOR))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute("acidenteSiarList", acidenteSiarService.listAcidentes());
		model.addAttribute("prioridadesList", Arrays.asList(AcidenteSiar.Prioridade.values()));

		model.addAttribute(Const.ATTR_TITLE, "Acidentes");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_ACIDENTES.getPath());
		return "acidentes";
	}
	
	@RequestMapping(value = EMERGENCIAS, method = RequestMethod.GET)
	public String getActiveAcidentesList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.ESPECIALISTA))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute("acidenteList", acidenteSiarService.listActiveAcidentes());
		
		model.addAttribute(Const.ATTR_TITLE, "Acidentes em aberto");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_EMERGENCIAS.getPath());
		return "acidentemissao";
	}
	
	@RequestMapping(value = ACIDENTES + Const.SAVE, method = RequestMethod.POST)
	public View saveAcidente(HttpServletRequest request, @ModelAttribute AcidenteSiar acidenteSiar, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.COORDENADOR))
			return new RedirectView(Const.HOME_ADDRESS);
		
		acidenteSiarService.saveAcidente(acidenteSiar);
		return new RedirectView(Const.SIAR + ACIDENTES);
	}
	
	@RequestMapping(value = ACIDENTES + Const.DELETE, method = RequestMethod.GET)
	public View removeAcidente(HttpServletRequest request, @PathVariable String id, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.COORDENADOR))
			return new RedirectView(Const.HOME_ADDRESS);
		
		acidenteSiarService.removeAcidente(id);
		return new RedirectView(Const.SIAR + ACIDENTES);
	}
	
	@RequestMapping(value = ACIDENTES + Const.UPDATE, method = RequestMethod.GET)
	public String updateAcidente(HttpServletRequest request, @PathVariable String id, ModelMap model){
		if (!autorizado(request, model, TipoUsuario.COORDENADOR))
			return Const.REDIRECT_UNAUTHORIZED;

		model.addAttribute("acidenteUpdate", acidenteSiarService.findAcidenteById(id));
		
		model.addAttribute(Const.ATTR_TITLE, "Editar acidente");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_ACIDENTES.getPath());
		return "updateacidente";
	}
}
