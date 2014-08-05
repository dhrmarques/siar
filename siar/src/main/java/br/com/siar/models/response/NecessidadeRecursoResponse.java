/**
 * 
 */
package br.com.siar.models.response;

import br.com.siar.models.NecessidadeRecursoSiar;
import br.com.siar.models.RecursoSiar;

/**
 * @author Leo
 *
 */
public class NecessidadeRecursoResponse {
	
	public NecessidadeRecursoResponse(NecessidadeRecursoSiar nrs, RecursoSiar r) {
		necessidade = nrs;
		recurso = r;
	}

	private NecessidadeRecursoSiar necessidade;
	private RecursoSiar recurso;
	
	public NecessidadeRecursoSiar getNecessidade() {
		return necessidade;
	}
	public void setNecessidade(NecessidadeRecursoSiar necessidade) {
		this.necessidade = necessidade;
	}
	public RecursoSiar getRecurso() {
		return recurso;
	}
	public void setRecurso(RecursoSiar recurso) {
		this.recurso = recurso;
	}
}
