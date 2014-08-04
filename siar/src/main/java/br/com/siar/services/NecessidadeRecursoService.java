/**
 * 
 */
package br.com.siar.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.siar.models.NecessidadeRecursoSiar;

/**
 * @author Leo
 *
 */
public class NecessidadeRecursoService extends BasicService {
	
	@Autowired
	private MongoTemplate siarmongoTemplate;
	
	public List<NecessidadeRecursoSiar> listNecessidadesForMissao(String missaoId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void saveNecessidades(List<NecessidadeRecursoSiar> necessidades) {
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
		return NecessidadeRecursoSiar.COLLECTION_NAME;
	}

	@Override
	protected Logger getLogger() {
		return LoggerFactory.getLogger(this.getClass());
	}

}
