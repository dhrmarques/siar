package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import br.com.siar.models.AtualizacaoMissaoSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.services.AtualizacaoMissaoSiarService;
import br.com.siar.utils.Const;

@Controller
public class AtualizacaoMissaoSiarController extends BasicController {

	@Autowired
	private AtualizacaoMissaoSiarService amsService;
	
	@RequestMapping(value = ATUALIZACOESMISSAO, method = RequestMethod.GET)
	public String getAtualizacoesList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.CHEFE_MISSAO))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Atualizações de Missão");
		model.addAttribute("amsList", amsService.listarAtualizacoes());
		return "am";
	}
	
	@RequestMapping(value = ATUALIZACOESMISSAO + Const.SAVE, method = RequestMethod.POST)
	public View saveAtualizacao(HttpServletRequest request, @ModelAttribute AtualizacaoMissaoSiar ams, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.CHEFE_MISSAO))
			return new RedirectView(Const.HOME_ADDRESS);
		
		amsService.saveAtualizacao(ams);
		return new RedirectView(Const.SIAR + ATUALIZACOESMISSAO);
	}	
}
