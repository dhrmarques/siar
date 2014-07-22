package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import br.com.siar.models.UsuarioSiar;
import br.com.siar.services.UsuarioSiarService;
import br.com.siar.utils.Constants;
import br.com.siar.utils.SessionHelper;

@Controller
@SessionAttributes("erro")
public class UsuarioSiarController {
	
	@Autowired
	private UsuarioSiarService usuarioSiarService;

	@RequestMapping(value = "/usuariosiar", method = RequestMethod.GET)
	public String getUsuariosList(ModelMap model) {
		model.addAttribute("usuarioSiarList", usuarioSiarService.listUsuarios());
		return "usuariosiar";
	}
	
	@RequestMapping(value = "/usuariosiar/save", method = RequestMethod.POST)
	public View saveUsuario(@ModelAttribute UsuarioSiar usuarioSiar, ModelMap model) {
		usuarioSiarService.saveUsuario(usuarioSiar);
		return new RedirectView("/siar/usuariosiar");
	}
	
	@RequestMapping(value = "/usuariosiar/delete/{id}")
	public View removeUsuario(@PathVariable String id, ModelMap model) {
		try {
			usuarioSiarService.removeUsuario(id);
		} catch (Exception e) {
			e.printStackTrace();
			//TODO Criar página de redirecionamento de erro
			return new RedirectView("/siar/usuariosiar/error");
		}
		return new RedirectView("/siar/usuariosiar");
	}
	
	@RequestMapping(value = "/usuariosiar/updateusuario/{id}", method = RequestMethod.GET)
	public String updateAcidente(@PathVariable String id, ModelMap model){
		model.addAttribute("usuarioUpdate", usuarioSiarService.findUsuarioById(id));
		return "updateusuario";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {
		//logger.info("Trying to log in...");
		
		String email = request.getParameter("login_email").toString();
		String senha = request.getParameter("login_password").toString();
		
		if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
			request.getSession().setAttribute(Constants.SESSION_ERROR_CODE, Constants.ERROR_FORM_INCOMPLETE);
			return "redirect:/";
		}
		
		//logger.debug("UsuarioSiarService: " + us.toString());
		UsuarioSiar usuario = usuarioSiarService.verify(email, senha);
		if (usuario != null) {
			
			SessionHelper.setUsuarioLogado(request, usuario);
			return "redirect:/home";
		}
		else {
			request.getSession().setAttribute(Constants.SESSION_ERROR_CODE, Constants.ERROR_LOGIN_NO_MATCH);
			return "redirect:/";
		}
		
	}
	
}
