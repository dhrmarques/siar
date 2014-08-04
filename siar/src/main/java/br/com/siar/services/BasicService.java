/**
 * 
 */
package br.com.siar.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;

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
	
	public <T extends BasicModel> T findModelById(Class<T> entityClass, String id) {
		return getSiarmongoTemplate().findById(new ObjectId(id), entityClass, getCollectionName());
	}
	
	public <T extends BasicModel> List<T> listModels(Class<T> entityClass) {
		return getSiarmongoTemplate().findAll(entityClass, getCollectionName());
	}
	
	public <T extends BasicModel> void saveModel(Class<T> entityClass, T model) {
		if (!getSiarmongoTemplate().collectionExists(entityClass)) {
			getSiarmongoTemplate().createCollection(entityClass);
		}
		getSiarmongoTemplate().save(model, getCollectionName());
	}
	
	public <T extends BasicModel> void removeModelById(Class<T> entityClass, String id) {
		
		try {
			T entity = getSiarmongoTemplate().findById(new ObjectId(id), entityClass, getCollectionName());
			entityClass.cast(entity);
			getSiarmongoTemplate().remove(entity, getCollectionName());
		} catch(Exception e) {
			getLogger().warn("Houve um erro ao remover a entidade", e);
		}
	}
}
