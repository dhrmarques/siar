/**
 * 
 */
package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.siar.services.MissaoSiarService;
import br.com.siar.services.RecursoSiarService;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@RequestMapping(value = ALOCACAO + Const.NEW, method = RequestMethod.POST)
	public String createAlocacao(HttpServletRequest request, ModelMap model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@RequestMapping(value = ALOCACAO + Const.SAVE, method = RequestMethod.POST)
	public String saveAlocacao(HttpServletRequest request, ModelMap model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private MissaoSiarService getMissaoService() {
		return appContext.getBean(MissaoSiarService.class);
	}
	private RecursoSiarService getRecursoService() {
		return appContext.getBean(RecursoSiarService.class);
	}
	private Object getNecessidadeRecursoService() {
		return appContext.getBean(MissaoSiarService.class);
	}
	private Object getSolicitacaoRecursoService() {
		return appContext.getBean(RecursoSiarService.class);
	}
	
	private ApplicationContext appContext;
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;
	}

}
