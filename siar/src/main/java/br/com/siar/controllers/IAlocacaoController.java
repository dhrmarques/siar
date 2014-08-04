/**
 * 
 */
package br.com.siar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.View;

/**
 * @author Leo
 *
 */
public interface IAlocacaoController {

	public String getMissoesPendentes(HttpServletRequest request, ModelMap model);
	public String createAlocacao(HttpServletRequest request, ModelMap model, String id);
	public View saveAlocacao(HttpServletRequest request, ModelMap model);
}
