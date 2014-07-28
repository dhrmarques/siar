/**
 * 
 */
package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import br.com.siar.models.TipoMissaoSiar;
import br.com.siar.models.UsuarioSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.services.TipoMissaoSiarService;
import br.com.siar.utils.Const;
import br.com.siar.utils.SessionHelper;

/**
 * @author Leo
 *
 */
public class TipoMissaoSiarController {

	@Autowired
	private TipoMissaoSiarService service;
	
	@RequestMapping(value = "/tiposmissao", method = RequestMethod.GET)
	public String getMissoesList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request, model))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Tipos de missão");
		model.addAttribute("tipoMissaoSiarList", service.listTiposMissao());
		return "tipomissaosiar";
	}
	
	@RequestMapping(value = "/tiposmissao/save", method = RequestMethod.POST)
	public View saveTipoMissao(HttpServletRequest request, @ModelAttribute TipoMissaoSiar tipo, ModelMap model) {
		if (!autorizado(request, model))
			return new RedirectView(Const.HOME_ADDRESS);
		
		service.saveTipoMissao(tipo);
		return new RedirectView("/siar/tiposmissao");
	}
	
	@RequestMapping(value = "/tiposmissao/delete/{id}", method = RequestMethod.GET)
	public View removeTipoMissao(HttpServletRequest request, @PathVariable String id, ModelMap model) {
		if (!autorizado(request, model))
			return new RedirectView(Const.HOME_ADDRESS);
		
		service.removeTipoMissao(id);
		return new RedirectView("/siar/tiposmissao");
	}
	
	@RequestMapping(value = "/tiposmissao/update/{id}", method = RequestMethod.GET)
	public String updateTipoMissao(HttpServletRequest request, @PathVariable String id, ModelMap model){
		if (!autorizado(request, model))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Editar missão");
		model.addAttribute("tipoMissaoUpdate", service.findTipoMissaoById(id));
		return "updatetipomissao";
	}
	
	private boolean autorizado(HttpServletRequest request, ModelMap model) {
		
		TipoUsuario tipo = TipoUsuario.ESPECIALISTA;
		
		UsuarioSiar usuario = SessionHelper.getUsuarioLogado(request);
		if (usuario != null && usuario.getTipoUsuario().equals(tipo)) {
			
			model.addAttribute(Const.ATTR_NAME, usuario.getNome());
			model.addAttribute(Const.ATTR_USER_TYPE, tipo.desc);
			
			return true;
		}
		return false;
	}
}
