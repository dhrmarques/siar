package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.com.siar.models.UsuarioSiar;
import br.com.siar.utils.Constants;
import br.com.siar.utils.SessionHelper;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("erro")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root(HttpServletRequest request, Model model, SessionStatus status) {
		logger.info("Homepage");

		HttpSession session = request.getSession();
		UsuarioSiar user = SessionHelper.getUsuarioLogado(request);
		
		if (user == null) {
			
			model.addAttribute("title", "Login SiAR");
			
			String visibility = "hidden";
			Integer error = (Integer) session.getAttribute(Constants.SESSION_ERROR_CODE);
			if (error != null && error != 0) {
				visibility = "visible";
				
				String msg = "";
				switch (error) {
				case Constants.ERROR_FORM_INCOMPLETE:
					msg = "Preencha todos os campos";
					break;
					
				case Constants.ERROR_LOGIN_NO_MATCH:
					msg = "Combinação usuário/senha inválida";
					break;
				}
				model.addAttribute("box_text", msg);
			}
			model.addAttribute("show_box", visibility);
			
			status.setComplete();
			return "login";
		}
		else {
			
			logger.warn("Already logged in...");
			return "redirect:/home";
			
		}
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
	
		UsuarioSiar user = SessionHelper.getUsuarioLogado(request);
		if (user == null)
			return "redirect:/";
		
		model.addAttribute("nome", user.getNome());
		
		switch (user.getTipoUsuario()) {
		case ADMINISTRADOR:
			return "admin";
			
		case CHEFE_MISSAO:
			return "chefemissao";
			
		case COORDENADOR:
			return "coordenador";
			
		case ESPECIALISTA:
			return "especialista";
			
		default:
			return "redirect:/";
		
		}
	}
	
}
