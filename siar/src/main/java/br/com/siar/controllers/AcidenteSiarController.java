package br.com.siar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String getCustomerList(ModelMap model) {
		model.addAttribute("acidenteSiarList", acidenteSiarService.listAcidentes());
		return "acidentesiar";
	}
	@RequestMapping(value = "/acidentesiar/save", method = RequestMethod.POST)
	public View saveCustomer(@ModelAttribute AcidenteSiar acidenteSiar, ModelMap model) {
		acidenteSiarService.saveAcidente(acidenteSiar);
		return new RedirectView("/siar/acidentesiar");
	}
	
}
