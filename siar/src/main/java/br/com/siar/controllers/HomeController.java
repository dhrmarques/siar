package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.siar.models.UsuarioSiar;
import br.com.siar.services.UsuarioSiarService;
import br.com.siar.utils.SessionHelper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		logger.info("Homepage");
		
		if (SessionHelper.getUsuarioLogado(request) == null) {
			
			model.addAttribute("title", "Login SiAR");
			return "login";
		}
		else {
			logger.warn("Already logged in...");
			return "home";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {
		logger.info("Trying to log in...");
		
		String email = request.getParameter("login_email").toString();
		String senha = request.getParameter("login_password").toString();
		
		UsuarioSiarService us = new UsuarioSiarService();
		UsuarioSiar usuario = us.verify(email, senha);
		if (usuario != null) {
			
			SessionHelper.setUsuarioLogado(request, usuario);
			return "redirect:/home";
		}
		else {
			
			return "redirect:/";
		}
		
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("welcomeMessage", "Dibs! Welcome to your first server page!");
		
		return "home";
	}*/
	
}
