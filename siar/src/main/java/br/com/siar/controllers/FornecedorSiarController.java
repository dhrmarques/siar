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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.siar.models.FornecedorSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.services.FornecedorSiarService;
import br.com.siar.utils.Const;


@Controller
public class FornecedorSiarController extends BasicController {

	@Autowired
	private FornecedorSiarService fornecedorService;
	
	@RequestMapping(value = FORNECEDORES, method = RequestMethod.GET)
	public String getFornecedoresList(HttpServletRequest request, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.ADMINISTRADOR))
			return Const.REDIRECT_UNAUTHORIZED;

		model.addAttribute("fornecedoresList", fornecedorService.listarFornecedores());
		
		model.addAttribute(Const.ATTR_TITLE, "Fornecedores");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_FORNECEDORES.getPath());
		return "fornecedores";
	}
	
	@RequestMapping(value = FORNECEDORES + Const.SAVE, method = RequestMethod.POST)
	public View saveFornecedor(HttpServletRequest request, @ModelAttribute FornecedorSiar fornecedor, ModelMap model, final RedirectAttributes redirectAttributes) {
		if (!autorizado(request, model, TipoUsuario.ADMINISTRADOR))
			return new RedirectView(Const.HOME_ADDRESS);
		
		if(fornecedor.getNome() == "" || fornecedor.getUrlSolicitacao() == ""){
			redirectAttributes.addFlashAttribute("cls", Const.CSS_ERROR_CLASS);
			redirectAttributes.addFlashAttribute("box_text", Const.FORM_INCOMPLETE);
		}else if(fornecedorService.findFornecedorByNome(fornecedor.getNome()) >= 1){
			redirectAttributes.addFlashAttribute("cls", Const.CSS_ERROR_CLASS);
			redirectAttributes.addFlashAttribute("box_text", Const.ALREADY_EXISTS);
		}else{
			redirectAttributes.addFlashAttribute("cls", Const.CSS_SUCCESS_CLASS);
			redirectAttributes.addFlashAttribute("box_text", Const.SUCCESS);
			fornecedorService.saveFornecedor(fornecedor);
		}
		
		return new RedirectView(Const.SIAR + FORNECEDORES);
	}
	
	@RequestMapping(value = FORNECEDORES + Const.UPDATE, method = RequestMethod.GET)
	public String updateFornecedor(HttpServletRequest request, @PathVariable String id, ModelMap model){
		if (!autorizado(request, model, TipoUsuario.ADMINISTRADOR))
			return Const.REDIRECT_UNAUTHORIZED;

		model.addAttribute("fornecedor", fornecedorService.findFornecedorById(id));
		
		model.addAttribute(Const.ATTR_TITLE, "Editar Fornecedor");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_FORNECEDORES.getPath());
		return "updatefornecedor";
	}
	
	@RequestMapping(value = FORNECEDORES + Const.DELETE)
	public View removeUsuario(HttpServletRequest request, @PathVariable String id, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.ADMINISTRADOR))
			return new RedirectView(Const.ROOT_ADDRESS);
		try {
			fornecedorService.removeFornecedor(id);
		} catch (Exception e) {
			e.printStackTrace();
			//TODO Criar página de redirecionamento de erro
			return new RedirectView("/siar/fornecedor/error");
		}
		return new RedirectView(Const.SIAR + FORNECEDORES);
	}	
}
