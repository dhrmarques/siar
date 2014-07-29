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

import br.com.siar.models.AtualizacaoMissaoSiar;
import br.com.siar.models.UsuarioSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.services.AtualizacaoMissaoSiarService;
import br.com.siar.utils.Const;
import br.com.siar.utils.SessionHelper;

@Controller
public class AtualizacaoMissaoSiarController {

	@Autowired
	private AtualizacaoMissaoSiarService amsService;
	
	@RequestMapping(value = "/ams", method = RequestMethod.GET)
	public String getAtualizacoesList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request, model))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Atualizações de Missão");
		model.addAttribute("amsList", amsService.listarAtualizacoes());
		return "ams";
	}
	
	@RequestMapping(value = "/ams/save", method = RequestMethod.POST)
	public View saveAtualizacao(HttpServletRequest request, @ModelAttribute AtualizacaoMissaoSiar ams, ModelMap model) {
		if (!autorizado(request, model))
			return new RedirectView(Const.HOME_ADDRESS);
		
		amsService.saveAtualizacao(ams);
		return new RedirectView("/siar/ams");
	}
	
	@RequestMapping(value = "/ams/update/{id}", method = RequestMethod.GET)
	public String updateAtualizacao(HttpServletRequest request, @PathVariable String id, ModelMap model){
		if (!autorizado(request, model))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Editar Atualização");
		model.addAttribute("recursoUpdate", amsService.findAtualizacaoById(id));
		return "updateams";
	}
	
	private boolean autorizado(HttpServletRequest request, ModelMap model) {
		
		TipoUsuario tipo = TipoUsuario.ADMINISTRADOR;
		
		UsuarioSiar usuario = SessionHelper.getUsuarioLogado(request);
		if (usuario != null && usuario.getTipoUsuario().equals(tipo)) {
			
			model.addAttribute(Const.ATTR_NAME, usuario.getNome());
			model.addAttribute(Const.ATTR_USER_TYPE, tipo.desc);
			
			return true;
		}
		return false;
	}
	
}
