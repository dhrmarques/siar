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

import br.com.siar.models.FornecedorSiar;
import br.com.siar.models.UsuarioSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.services.FornecedorSiarService;
import br.com.siar.utils.Const;
import br.com.siar.utils.SessionHelper;


@Controller
public class FornecedorSiarController {

	@Autowired
	private FornecedorSiarService fornecedorService;
	
	@RequestMapping(value = "/fornecedor", method = RequestMethod.GET)
	public String getFornecedoresList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request, model))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Fornecedores");
		model.addAttribute("amsList", fornecedorService.listarFornecedores());
		return "fornecedor";
	}
	
	@RequestMapping(value = "/fornecedor/save", method = RequestMethod.POST)
	public View saveFornecedor(HttpServletRequest request, @ModelAttribute FornecedorSiar fornecedor, ModelMap model) {
		if (!autorizado(request, model))
			return new RedirectView(Const.HOME_ADDRESS);
		
		fornecedorService.saveFornecedor(fornecedor);
		return new RedirectView("/siar/fornecedor");
	}
	
	@RequestMapping(value = "/fornecedor/update/{id}", method = RequestMethod.GET)
	public String updateFornecedor(HttpServletRequest request, @PathVariable String id, ModelMap model){
		if (!autorizado(request, model))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute(Const.ATTR_TITLE, "Editar Fornecedor");
		model.addAttribute("fornecedorUpdate", fornecedorService.findFornecedorById(id));
		return "updatefornecedor";
	}
	
	@RequestMapping(value = "/fornecedor/delete/{id}")
	public View removeUsuario(HttpServletRequest request, @PathVariable String id, ModelMap model) {
		if (!autorizado(request, model))
			return new RedirectView(Const.ROOT_ADDRESS);
		try {
			fornecedorService.removeFornecedor(id);
		} catch (Exception e) {
			e.printStackTrace();
			//TODO Criar página de redirecionamento de erro
			return new RedirectView("/siar/fornecedor/error");
		}
		return new RedirectView("/siar/fornecedor");
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
