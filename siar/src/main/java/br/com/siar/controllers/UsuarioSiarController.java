package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@SessionAttributes({"erro", "email"})
public class UsuarioSiarController {
	
	@Autowired
	private UsuarioSiarService usuarioSiarService;

	@RequestMapping(value = "/usuariosiar", method = RequestMethod.GET)
	public String getUsuariosList(HttpServletRequest request, ModelMap model) {
		model.addAttribute("title", "Usuários");
		
		if (!autorizado(request, model))
			return Constants.REDIRECT_UNAUTHORIZED;
		model.addAttribute("usuarioSiarList", usuarioSiarService.listUsuarios());
		return "usuariosiar";
	}
	
	@RequestMapping(value = "/usuariosiar/save", method = RequestMethod.POST)
	public View saveUsuario(HttpServletRequest request, @ModelAttribute UsuarioSiar usuarioSiar, ModelMap model) {
		
		if (!autorizado(request, model))
			return new RedirectView("/");
		usuarioSiarService.saveUsuario(usuarioSiar);
		return new RedirectView("/siar/usuariosiar");
	}
	
	@RequestMapping(value = "/usuariosiar/delete/{id}")
	public View removeUsuario(HttpServletRequest request, @PathVariable String id, ModelMap model) {
		if (!autorizado(request, model))
			return new RedirectView("/");
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
	public String updateUsuario(HttpServletRequest request, @PathVariable String id, ModelMap model){
		model.addAttribute("title", "Editar usuário");
		
		if (!autorizado(request, model))
			return Constants.REDIRECT_UNAUTHORIZED;
		model.addAttribute("usuarioUpdate", usuarioSiarService.findUsuarioById(id));
		return "updateusuario";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request) {
		
		String email = request.getParameter("login_email").toString();
		String senha = request.getParameter("login_password").toString();
		
		if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
			
			request.getSession().setAttribute(Constants.SESSION_ERROR_CODE, Constants.ERROR_FORM_INCOMPLETE);
		}
		else {
			UsuarioSiar usuario = usuarioSiarService.verify(email, senha);
			if (usuario != null) {
				
				SessionHelper.setUsuarioLogado(request, usuario);
				return Constants.REDIRECT_HOME;
			}
			else {
				request.getSession().setAttribute(Constants.SESSION_ERROR_CODE, Constants.ERROR_LOGIN_NO_MATCH);
			}
		}
		if (email != null)
			request.getSession().setAttribute(Constants.SESSION_EMAIL, email);
		return Constants.REDIRECT_NOT_LOGGED;
	}
	
	private boolean autorizado(HttpServletRequest request, ModelMap model) {
		
		UsuarioSiar usuario = SessionHelper.getUsuarioLogado(request);
		if (usuario != null && usuario.getTipoUsuario().equals(UsuarioSiar.TipoUsuario.ADMINISTRADOR)) {
			model.addAttribute("nome", usuario.getNome());
			model.addAttribute("tipo_usuario", "Administrador");
			return true;
		}
		return false;
	}
	
}
