package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.siar.models.UsuarioSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.utils.Const;
import br.com.siar.utils.SessionHelper;

@Controller
public class AcessoSVCController {

	private static final Logger logger = LoggerFactory.getLogger(AcessoSVCController.class);
	
	@RequestMapping(value="/acessosvc")
	public String acessarSVC(HttpServletRequest request) {
		UsuarioSiar user = SessionHelper.getUsuarioLogado(request);
		if(user.getTipoUsuario().equals(TipoUsuario.COORDENADOR)) {
			logger.info("User successfully logged in!");
			return "acessosvc";
		}
		logger.warn("User has no permission / User not logged in!");
		return Const.REDIRECT_HOME;
	}
	
}
