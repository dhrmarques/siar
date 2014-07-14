package br.com.siar.controllers;

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
import br.com.siar.services.AcidenteSiarService;

@Controller
public class AcidenteSiarController {

	@Autowired
	private AcidenteSiarService acidenteSiarService;
	
	@RequestMapping(value = "/acidentesiar", method = RequestMethod.GET)
	public String getAcidentesList(ModelMap model) {
		model.addAttribute("acidenteSiarList", acidenteSiarService.listAcidentes());
		return "acidentesiar";
	}
	
	@RequestMapping(value = "/acidentesiar/save", method = RequestMethod.POST)
	public View saveAcidente(@ModelAttribute AcidenteSiar acidenteSiar, ModelMap model) {
		acidenteSiarService.saveAcidente(acidenteSiar);
		return new RedirectView("/siar/acidentesiar");
	}
	
	@RequestMapping(value = "/acidentesiar/delete/{id}", method = RequestMethod.GET)
	public View removeAcidente(@PathVariable String id, ModelMap model) {
		acidenteSiarService.removeAcidente(id);
		return new RedirectView("/siar/acidentesiar");
	}
	
	@RequestMapping(value = "/acidentesiar/updateacidente/{id}", method = RequestMethod.GET)
	public String updateAcidente(@PathVariable String id, ModelMap model){
		model.addAttribute("acidenteUpdate", acidenteSiarService.findAcidenteById(id));
		return "updateacidente";
	}
	
}
