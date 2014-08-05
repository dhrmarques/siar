/**
 * 
 */
package br.com.siar.services;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.siar.models.NecessidadeRecursoSiar;
import br.com.siar.models.RecursoSiar;
import br.com.siar.models.response.NecessidadeRecursoResponse;

/**
 * @author Leo
 *
 */
public class NecessidadeRecursoService extends BasicService {
	
	@Autowired
	private MongoTemplate siarmongoTemplate;
	
	public List<NecessidadeRecursoResponse> listNecessidadesForMissao(String missaoId) {
		
		Query q = new Query(Criteria.where("missaoId").is(new ObjectId(missaoId)));
		List<NecessidadeRecursoSiar> necessidades =  siarmongoTemplate.find(q, NecessidadeRecursoSiar.class, getCollectionName());
		
		List<NecessidadeRecursoResponse> response = new ArrayList<NecessidadeRecursoResponse>();
		for (NecessidadeRecursoSiar nrs : necessidades) {
			ObjectId recursoId = nrs.getRecursoId();
			RecursoSiar recurso = siarmongoTemplate.findById(recursoId, RecursoSiar.class);
			response.add(new NecessidadeRecursoResponse(nrs, recurso));
		}
		
		return response;
	}
	
	public void saveNecessidades(List<NecessidadeRecursoSiar> necessidades) {
		for (NecessidadeRecursoSiar nrs : necessidades) {
			saveModel(NecessidadeRecursoSiar.class, nrs);
		}
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
