/**
 * 
 */
package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.utils.Const;

/**
 * @author Leo
 *
 */
public class ReportsController extends BasicController {

	@RequestMapping(value = RELATORIOS, method = RequestMethod.GET)
	public String formRelatórios(HttpServletRequest request, ModelMap model) {
		
		if (!autorizado(request, model, TipoUsuario.COORDENADOR))
			return Const.REDIRECT_UNAUTHORIZED;
		
		return "";
	}
}
