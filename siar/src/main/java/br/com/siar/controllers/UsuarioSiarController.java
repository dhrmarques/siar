package br.com.siar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.siar.services.UsuarioService;

@Controller
public class UsuarioSiarController {
	
	@Autowired
	private UsuarioService usuarioSiarService;

	@RequestMapping(value = "/acidentesiar", method = RequestMethod.GET)
	public String getAcidentesList(ModelMap model) {
		model.addAttribute("usuarioSiarList", usuarioSiarService.listUsuarios());
		return "usuariosiar";
	}
	
}
