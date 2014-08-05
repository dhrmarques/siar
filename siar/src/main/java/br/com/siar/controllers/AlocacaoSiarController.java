/**
 * 
 */
package br.com.siar.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bson.types.ObjectId;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import br.com.siar.models.FornecedorSiar;
import br.com.siar.models.MissaoSiar;
import br.com.siar.models.SolicitacaoRecursoSiar;
import br.com.siar.models.StatusMissao;
import br.com.siar.models.UsuarioSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.models.response.MissaoResponse;
import br.com.siar.models.response.NecessidadeRecursoResponse;
import br.com.siar.services.FornecedorSiarService;
import br.com.siar.services.MissaoSiarService;
import br.com.siar.services.NecessidadeRecursoService;
import br.com.siar.services.SolicitacaoRecursoService;
import br.com.siar.services.UsuarioSiarService;
import br.com.siar.utils.Const;

/**
 * @author Leo
 *
 */
@Controller
public class AlocacaoSiarController extends BasicController implements ApplicationContextAware, IAlocacaoController {

	@Override
	@RequestMapping(value = ALOCACAO, method = RequestMethod.GET)
	public String getMissoesPendentes(HttpServletRequest request, ModelMap model) {

		if (!autorizado(request, model, TipoUsuario.COORDENADOR))
			return Const.REDIRECT_UNAUTHORIZED;
		
		model.addAttribute("missoesList", getMissaoService().listMissoesPendentes());

		model.addAttribute(Const.ATTR_TITLE, "Missões pendentes");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_ALOCACAO.getPath());
		return "alocacaosiar";
	}
	
	@Override
	@RequestMapping(value = ALOCACAO + Const.NEW, method = RequestMethod.POST)
	public String createAlocacao(HttpServletRequest request, ModelMap model) {
		
		if (!autorizado(request, model, TipoUsuario.COORDENADOR))
			return Const.REDIRECT_UNAUTHORIZED;
		
		String id = request.getParameter("missaoId");
		MissaoResponse missao = getMissaoService().findMissaoById(id);
		model.addAttribute("missaoResponse", missao);
		
		List<UsuarioSiar> chefesDeMissao = getUsuarioSiarService().listChefesDeMissao();
		model.addAttribute("chefesList", chefesDeMissao);
		
		List<NecessidadeRecursoResponse> necessidades = getNecessidadeRecursoService().listNecessidadesForMissao(id);
		model.addAttribute("necessidadesList", necessidades);
		
		List<FornecedorSiar> fornecedores = getFornecedorService().listarFornecedores();
		model.addAttribute("fornecedoresList", fornecedores);
		
		model.addAttribute(Const.ATTR_TITLE, "Alocar recursos");
		model.addAttribute(Const.ATTR_LINK_ACTIVE, LINK_ALOCACAO.getPath());
		return "createalocacao";
	}
	
	@Override
	@RequestMapping(value = ALOCACAO + Const.SAVE, method = RequestMethod.POST)
	public View saveAlocacao(HttpServletRequest request, ModelMap model) {
		
		if (!autorizado(request, model, TipoUsuario.COORDENADOR))
			return new RedirectView(Const.HOME_ADDRESS);
		
		ObjectId missaoId = new ObjectId(request.getParameter("missaoId"));
		ObjectId chefeId = new ObjectId(request.getParameter("chefeId"));
		
		String[] idNecessidades = request.getParameterValues("necessidadeId");
		String[] idFornecedores = request.getParameterValues("fornecedorId");
		String[] quantidades = request.getParameterValues("quantidade");
		
		List<SolicitacaoRecursoSiar> solicitacoes = new ArrayList<SolicitacaoRecursoSiar>();
		for (int i = 0 ; i < idNecessidades.length ; i++) {
			solicitacoes.add(new SolicitacaoRecursoSiar(
					idNecessidades[i],
					idFornecedores[i],
					Integer.parseInt(quantidades[i])
			));
		}
		getSolicitacaoRecursoService().saveSolicitacoes(solicitacoes);
		
		MissaoSiar missao = getMissaoService().findMissaoById(missaoId.toString()).getMissao();
		missao.setStatus(StatusMissao.AGUARDANDO_RECURSOS);
		missao.setChefeId(chefeId);
		getMissaoService().saveMissao(missao);
		
		return new RedirectView(Const.SIAR + ALOCACAO);
	}
	
	private MissaoSiarService getMissaoService() {
		return appContext.getBean(MissaoSiarService.class);
	}
	private NecessidadeRecursoService getNecessidadeRecursoService() {
		return appContext.getBean(NecessidadeRecursoService.class);
	}
	private FornecedorSiarService getFornecedorService() {
		return appContext.getBean(FornecedorSiarService.class);
	}
	private SolicitacaoRecursoService getSolicitacaoRecursoService() {
		return appContext.getBean(SolicitacaoRecursoService.class);
	}
	private UsuarioSiarService getUsuarioSiarService() {
		return appContext.getBean(UsuarioSiarService.class);
	}
	
	private ApplicationContext appContext;
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;
	}

}
