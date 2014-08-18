/**
 * 
 */
package br.com.siar.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.siar.models.RecursoSiar;

/**
 * @author Leo
 *
 */
public class RecursoSiarService extends BasicService {
	
	private static final String COLLECTION_NAME = RecursoSiar.COLLECTION_NAME;

	@Autowired
	private MongoTemplate siarmongoTemplate;
	
	public RecursoSiar findRecursoById(String id){
		return findModelById(RecursoSiar.class, id);
	}
	
	public int findRecursoByName(String name){
		Query q = new Query(Criteria.where("nome").is(name));
		return siarmongoTemplate.find(q, RecursoSiar.class, RecursoSiar.COLLECTION_NAME).size();
	}
	
	public List<RecursoSiar> listRecursos() {
		return listModels(RecursoSiar.class);
	}
	
	public void saveRecurso(RecursoSiar recurso) {
		saveModel(RecursoSiar.class, recurso);
	}
	
	public void removeRecurso(String id) {
		// TODO check if it CAN be removed
		removeModelById(RecursoSiar.class, id);
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
	public String getCollectionName() {
		return COLLECTION_NAME;
	}

	@Override
	public Logger getLogger() {
		return LoggerFactory.getLogger(this.getClass());
	}

}
