/**
 * 
 */
package br.com.siar.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.siar.models.RecursoSiar;

/**
 * @author Leo
 *
 */
public class RecursoSiarService {
	
	private static final String COLLECTION_NAME = "recursoSiar";

	@Autowired
	private MongoTemplate siarmongoTemplate;
	private static Logger logger;
	
	//Getter and setter for template.
	public MongoTemplate getSiarmongoTemplate() {
		return siarmongoTemplate;
	}

	public void setSiarmongoTemplate(MongoTemplate siarmongoTemplate) {
		this.siarmongoTemplate = siarmongoTemplate;
	}
	
	//Service methods.
		public void saveRecurso(RecursoSiar recurso) {
			if (!siarmongoTemplate.collectionExists(RecursoSiar.class)) {
				siarmongoTemplate.createCollection(RecursoSiar.class);
			}
			//Checking if the object already exists
			if ((siarmongoTemplate.findById(recurso.getId(), RecursoSiar.class, COLLECTION_NAME)) != null) {
				siarmongoTemplate.save(recurso, COLLECTION_NAME);
			}
			siarmongoTemplate.insert(recurso, COLLECTION_NAME);
		}
		
		public RecursoSiar findRecursoById(String id){
			return siarmongoTemplate.findById(new ObjectId(id), RecursoSiar.class, COLLECTION_NAME);
		}
		
		public List<RecursoSiar> listRecursos() {
			return siarmongoTemplate.findAll(RecursoSiar.class, COLLECTION_NAME);
		}
		
		public void removeRecurso(String id) {
			try {
				ObjectId _id = new ObjectId(id);
				RecursoSiar recurso = siarmongoTemplate.findById(_id, RecursoSiar.class, COLLECTION_NAME);
				siarmongoTemplate.remove(recurso, COLLECTION_NAME);
			} catch(Exception e) {
				logger.warn("Houve um erro ao remover o recurso indicado", e);
			}
		}

}
