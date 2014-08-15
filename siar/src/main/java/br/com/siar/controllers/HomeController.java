package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import br.com.siar.models.UsuarioSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.services.StartupService;
import br.com.siar.utils.Const;
import br.com.siar.utils.SessionHelper;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"erro", "email"})
public class HomeController extends BasicController implements ApplicationContextAware {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = Const.ROOT_ADDRESS, method = RequestMethod.GET)
	public String root(HttpServletRequest request, Model model, SessionStatus status) {
		logger.info("Homepage");

		HttpSession session = request.getSession();
		UsuarioSiar user = SessionHelper.getUsuarioLogado(request);
		
		if (user == null) {
			
			model.addAttribute(Const.ATTR_TITLE, "Login SiAR");
			model.addAttribute(Const.ATTR_HIDE_HR, Boolean.TRUE);
			
			String visibility = "hidden";
			Integer error = (Integer) session.getAttribute(Const.SESSION_ERROR_CODE);
			if (error != null && error != 0) {
				visibility = "visible";
				
				String msg = "";
				switch (error) {
				case Const.ERROR_FORM_INCOMPLETE:
					msg = "Preencha todos os campos";
					break;
					
				case Const.ERROR_LOGIN_NO_MATCH:
					msg = "Combinação usuário/senha inválida";
					break;
				}
				model.addAttribute("box_text", msg);
				
				String email = (String) session.getAttribute(Const.SESSION_EMAIL);
				if (session.getAttribute(Const.SESSION_EMAIL) != null) {
					logger.info("Email recuperado: " + email);
					model.addAttribute("email", session.getAttribute(Const.SESSION_EMAIL));
				}
			}
			model.addAttribute("show_box", visibility);
			
			status.setComplete();
			return "login";
		}
		else {
			
			logger.warn("Already logged in...");
			return Const.REDIRECT_HOME;
			
		}
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request, ModelMap model) {
	
		if (!autorizado(request, model))
			return Const.REDIRECT_NOT_LOGGED;
		
		model.addAttribute(Const.ATTR_TITLE, "Homepage");
		TipoUsuario tipoUser = (TipoUsuario) model.get(Const.ATTR_USER_TYPE);
		
		if (tipoUser == null)
			return Const.REDIRECT_NOT_LOGGED;
		else if (tipoUser.equals(TipoUsuario.CHEFE_MISSAO))
			return Const.REDIRECT_CHEFEMISSAO;
		
		return tipoUser.homefile;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, SessionStatus status) {
		
		request.getSession().removeAttribute(Const.SESSION_KEY_USER);
		status.setComplete();
		return Const.REDIRECT_NOT_LOGGED;
	}
	
	@RequestMapping(value = "/secretPathThatNoOneWillEverFindOutUnlessTheyCheckOurCode")
	public View startup(HttpServletRequest request) {
		
		getStartupService().createFirstAdmin();
		
		return new RedirectView(Const.SIAR);
	}
	
	@RequestMapping(value = "/secretPathBetweenTheMistyMountains")
	public View startup2(HttpServletRequest request) {
		
		getStartupService().createTiposDeMissao();
		
		return new RedirectView(Const.ROOT_ADDRESS);
	}
	
	private StartupService getStartupService() {
		return appContext.getBean(StartupService.class);
	}
		
	private ApplicationContext appContext;
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;
	}
}
