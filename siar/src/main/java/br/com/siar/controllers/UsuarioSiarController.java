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
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.services.UsuarioSiarService;
import br.com.siar.utils.Const;
import br.com.siar.utils.SessionHelper;

@Controller
@SessionAttributes({"erro", "email"})
public class UsuarioSiarController extends BasicController {
	
	@Autowired
	private UsuarioSiarService usuarioSiarService;

	@RequestMapping(value = USUARIOS, method = RequestMethod.GET)
	public String getUsuariosList(HttpServletRequest request, ModelMap model) {
		
		if (!autorizado(request, model, TipoUsuario.ADMINISTRADOR))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute("usuarioSiarList", usuarioSiarService.listUsuarios());
		
		model.addAttribute(Const.ATTR_TITLE, "Usuários");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_USUARIOS.getPath());
		return "usuarios";
	}
	
	@RequestMapping(value = USUARIOS + Const.SAVE, method = RequestMethod.POST)
	public View saveUsuario(HttpServletRequest request, @ModelAttribute UsuarioSiar usuarioSiar, ModelMap model) {
		
		if (!autorizado(request, model, TipoUsuario.ADMINISTRADOR))
			return new RedirectView(Const.ROOT_ADDRESS);
		usuarioSiarService.saveUsuario(usuarioSiar);
		return new RedirectView(Const.SIAR + USUARIOS);
	}
	
	@RequestMapping(value = USUARIOS + Const.UPDATE)
	public View removeUsuario(HttpServletRequest request, @PathVariable String id, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.ADMINISTRADOR))
			return new RedirectView(Const.ROOT_ADDRESS);
		try {
			usuarioSiarService.removeUsuario(id);
		} catch (Exception e) {
			e.printStackTrace();
			//TODO Criar página de redirecionamento de erro
			return new RedirectView(Const.SIAR + USUARIOS + "/error");
		}
		return new RedirectView(Const.SIAR + USUARIOS);
	}
	
	@RequestMapping(value = USUARIOS + Const.UPDATE, method = RequestMethod.GET)
	public String updateUsuario(HttpServletRequest request, @PathVariable String id, ModelMap model){
		
		if (!autorizado(request, model, TipoUsuario.ADMINISTRADOR))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute("usuarioUpdate", usuarioSiarService.findUsuarioById(id));
		
		model.addAttribute(Const.ATTR_TITLE, "Editar usuário");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_USUARIOS.getPath());
		return "updateusuario";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request) {
		
		String email = request.getParameter("login_email").toString();
		String senha = request.getParameter("login_password").toString();
		
		if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
			
			request.getSession().setAttribute(Const.SESSION_ERROR_CODE, Const.ERROR_FORM_INCOMPLETE);
		}
		else {
			UsuarioSiar usuario = usuarioSiarService.verify(email, senha);
			if (usuario != null) {
				
				SessionHelper.setUsuarioLogado(request, usuario);
				return Const.REDIRECT_HOME;
			}
			else {
				request.getSession().setAttribute(Const.SESSION_ERROR_CODE, Const.ERROR_LOGIN_NO_MATCH);
			}
		}
		if (email != null)
			request.getSession().setAttribute(Const.SESSION_EMAIL, email);
		return Const.REDIRECT_NOT_LOGGED;
	}
	
}
