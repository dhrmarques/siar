package br.com.siar.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.siar.models.AcidenteSiar;

public class AcidenteSiarService {
	
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
	public void saveAcidente(AcidenteSiar acidenteSiar) {
		if (!siarmongoTemplate.collectionExists(AcidenteSiar.class)) {
			siarmongoTemplate.createCollection(AcidenteSiar.class);
		}
		//Checking if the acidenteSiar object already exists
		if ((siarmongoTemplate.findById(acidenteSiar.getId(), AcidenteSiar.class, AcidenteSiar.COLLECTION_NAME)) != null) {
			siarmongoTemplate.save(acidenteSiar, AcidenteSiar.COLLECTION_NAME);
		}
		siarmongoTemplate.insert(acidenteSiar, AcidenteSiar.COLLECTION_NAME);
	}
	
	public AcidenteSiar findAcidenteById(String id){
		return siarmongoTemplate.findById(new ObjectId(id), AcidenteSiar.class, AcidenteSiar.COLLECTION_NAME);
	}
	
	public List<AcidenteSiar> listAcidentes() {
		return siarmongoTemplate.findAll(AcidenteSiar.class, AcidenteSiar.COLLECTION_NAME);
	}
	
	public List<AcidenteSiar> listActiveAcidentes() {
		Query q = new Query(); // TODO
		q.addCriteria(Criteria.where("prioridade").is("Baixa"));

		return siarmongoTemplate.find(q, AcidenteSiar.class, AcidenteSiar.COLLECTION_NAME);
	}
	
	public void removeAcidente(String id) {
		try {
			ObjectId _id = new ObjectId(id);
			AcidenteSiar acidente = siarmongoTemplate.findById(_id, AcidenteSiar.class, AcidenteSiar.COLLECTION_NAME);
			siarmongoTemplate.remove(acidente, AcidenteSiar.COLLECTION_NAME);
		} catch(Exception e) {
			logger.warn("Houve um erro ao remover o acidente indicado", e);
		}
	}
	
}

