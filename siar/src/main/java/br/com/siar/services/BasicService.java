/**
 * 
 */
package br.com.siar.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import br.com.siar.models.BasicModel;

/**
 * @author Leo
 *
 */
public abstract class BasicService {

	public abstract MongoTemplate getSiarmongoTemplate();
	public abstract void setSiarmongoTemplate(MongoTemplate siarmongoTemplate);
	protected abstract String getCollectionName();
	protected abstract Logger getLogger();
	
	protected static Query queryAtiva() {
		return new Query(Criteria.where("ativo").is(true));
	}
	
	public <T extends BasicModel> T findModelById(Class<T> entityClass, String id) {
		return getSiarmongoTemplate().findById(new ObjectId(id), entityClass, getCollectionName());
	}
	
	public <T extends BasicModel> List<T> listModels(Class<T> entityClass) {
		Query q = queryAtiva();
		return getSiarmongoTemplate().find(q, entityClass, getCollectionName());
	}
	
	public <T extends BasicModel> void saveModel(Class<T> entityClass, T model) {
		if (!getSiarmongoTemplate().collectionExists(entityClass)) {
			getSiarmongoTemplate().createCollection(entityClass);
		}
		model.setAtivo(true);
		getSiarmongoTemplate().save(model, getCollectionName());
	}
	
	public <T extends BasicModel> void removeModelById(Class<T> entityClass, String id) {
		
		try {
			Query q = new Query(Criteria.where("_id").is(new ObjectId(id)));
			Update u = new Update();
			u.set("ativo", false);
			getSiarmongoTemplate().updateFirst(q, u, getCollectionName());
		} catch(Exception e) {
			getLogger().warn("Houve um erro ao remover a entidade", e);
		}
	}
}
