package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.utils.Const;

@Controller
public class AcessoSVCController extends BasicController {
	
	@RequestMapping(value = SVC)
	public String acessarSVC(HttpServletRequest request, ModelMap model) {
		
		if (!autorizado(request, model, TipoUsuario.COORDENADOR))
			return Const.REDIRECT_HOME;
		
		model.addAttribute(Const.ATTR_TITLE, "SVC");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_SVC.getPath());
		return "acessosvc";
	}
}
