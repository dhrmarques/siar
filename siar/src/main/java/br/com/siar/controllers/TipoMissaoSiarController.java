/**
 * 
 */
package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import br.com.siar.models.TipoMissaoSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.services.TipoMissaoSiarService;
import br.com.siar.utils.Const;

/**
 * @author Leo
 *
 */
@Controller
public class TipoMissaoSiarController extends BasicController {

	@Autowired
	private TipoMissaoSiarService tipoMissaoService;
	
	@RequestMapping(value = TIPOSMISSAO, method = RequestMethod.GET)
	public String getMissoesList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.ESPECIALISTA))
			return Const.REDIRECT_UNAUTHORIZED;

		model.addAttribute("tipoMissaoSiarList", tipoMissaoService.listTiposMissao());
		
		model.addAttribute(Const.ATTR_TITLE, "Tipos de missão");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_TIPOSMISSAO.getPath());
		return "tipomissaosiar";
	}
	
	@RequestMapping(value = TIPOSMISSAO + Const.SAVE, method = RequestMethod.POST)
	public View saveTipoMissao(HttpServletRequest request, @ModelAttribute TipoMissaoSiar tipo, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.ESPECIALISTA))
			return new RedirectView(Const.HOME_ADDRESS);
		
		tipoMissaoService.saveTipoMissao(tipo);
		return new RedirectView(Const.SIAR + TIPOSMISSAO);
	}
	
	@RequestMapping(value = TIPOSMISSAO + Const.DELETE, method = RequestMethod.GET)
	public View removeTipoMissao(HttpServletRequest request, @PathVariable String id, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.ESPECIALISTA))
			return new RedirectView(Const.HOME_ADDRESS);
		
		tipoMissaoService.removeTipoMissao(id);
		return new RedirectView(Const.SIAR + TIPOSMISSAO);
	}
	
	@RequestMapping(value = TIPOSMISSAO + Const.UPDATE, method = RequestMethod.GET)
	public String updateTipoMissao(HttpServletRequest request, @PathVariable String id, ModelMap model){
		if (!autorizado(request, model, TipoUsuario.ESPECIALISTA))
			return Const.REDIRECT_UNAUTHORIZED;

		model.addAttribute("tipo", tipoMissaoService.findTipoMissaoById(id));
		
		model.addAttribute(Const.ATTR_TITLE, "Editar missão");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_TIPOSMISSAO.getPath());
		return "updatetipomissao";
	}
}
