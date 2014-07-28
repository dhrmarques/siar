package br.com.siar.utils;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.siar.models.UsuarioSiar;

public class SessionHelper {
	
	private static final Logger logger = LoggerFactory.getLogger(SessionHelper.class);

	public static final UsuarioSiar getUsuarioLogado(HttpServletRequest request) {
		
		Object attr = request.getSession().getAttribute(Const.SESSION_KEY_USER);
		if (attr != null && attr instanceof UsuarioSiar) {
			UsuarioSiar usuario = (UsuarioSiar) attr;
			
			logger.info("Usuario logado: "
			+ usuario.getNome() + " [" + usuario.getId() + "]");
			
			return usuario;
		}
		
		return null;
	}
	
	public static final boolean isUsuarioLogadoTipo(HttpServletRequest request, UsuarioSiar.TipoUsuario tipo) {
		
		UsuarioSiar user = getUsuarioLogado(request);
		if (user == null)
			return false;
		return user.getTipoUsuario().equals(tipo);
	}

	public static final void setUsuarioLogado(HttpServletRequest request, UsuarioSiar usuario) {
		logger.info("Saving session for user " + usuario.getNome());
		request.getSession().setAttribute(Const.SESSION_KEY_USER, usuario);
	}
}
