/**
 * 
 */
package br.com.siar.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.siar.models.SolicitacaoRecursoSiar;

/**
 * @author Leo
 *
 */
public class SolicitacaoRecursoService extends BasicService {
	
	@Autowired
	private MongoTemplate siarmongoTemplate;
	
	public void saveSolicitacoes(List<SolicitacaoRecursoSiar> solicitacoes) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public MongoTemplate getSiarmongoTemplate() {
		return siarmongoTemplate;
	}

	@Override
	public void setSiarmongoTemplate(MongoTemplate siarmongoTemplate) {
		this.siarmongoTemplate = siarmongoTemplate;
	}

	@Override
	protected String getCollectionName() {
		return SolicitacaoRecursoSiar.COLLECTION_NAME;
	}

	@Override
	protected Logger getLogger() {
		return LoggerFactory.getLogger(this.getClass());
	}

}
