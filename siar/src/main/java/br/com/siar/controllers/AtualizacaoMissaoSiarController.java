package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.bson.types.ObjectId;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import br.com.siar.models.AtualizacaoMissaoSiar;
import br.com.siar.models.StatusMissao;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.models.response.MissaoResponse;
import br.com.siar.services.AtualizacaoMissaoSiarService;
import br.com.siar.services.MissaoSiarService;
import br.com.siar.utils.Const;

@Controller
public class AtualizacaoMissaoSiarController extends BasicController implements ApplicationContextAware {

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
	
	@RequestMapping(value = Const.CHEFEMISSAO_ADDRESS + Const.SAVE, method = RequestMethod.POST)
	public View saveAtualizacao(HttpServletRequest request, @ModelAttribute AtualizacaoMissaoSiar ams, ModelMap model) {
		if (!autorizado(request, model, TipoUsuario.CHEFE_MISSAO))
			return new RedirectView(Const.HOME_ADDRESS);
		
		ams.setUsuarioId((ObjectId) model.get(Const.ATTR_USER_ID));
		
		amsService.saveAtualizacao(ams);
		ObjectId missaoId = new ObjectId(request.getParameter("missaoId"));
		StatusMissao status = StatusMissao.valueOf(request.getParameter("status"));
		getMissaoSiarService().updateMissaoStatus(missaoId, status);
		
		return new RedirectView(Const.SIAR + Const.CHEFEMISSAO_ADDRESS);
	}
	
	@RequestMapping(value = Const.CHEFEMISSAO_ADDRESS, method = RequestMethod.GET)
	public String homeChefeDeMissao(HttpServletRequest request, ModelMap model) {
		
		if (!autorizado(request, model, TipoUsuario.CHEFE_MISSAO))
			return Const.REDIRECT_UNAUTHORIZED;
		
		String chefeId = model.get(Const.ATTR_USER_ID).toString();
		MissaoResponse missao = getMissaoSiarService().missaoForChefe(chefeId);
		
		if (missao == null)
			return "chefemissao";
		
		model.addAttribute("missaoResponse", missao);
		model.addAttribute("statusPossiveis", missao.getMissao().getStatus().proximos());
		return "asm";
	}
	
	private MissaoSiarService getMissaoSiarService() {
		return appContext.getBean(MissaoSiarService.class);
	}

	ApplicationContext appContext;
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		this.appContext = arg0;
	}
}
