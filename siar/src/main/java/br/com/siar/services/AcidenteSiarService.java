package br.com.siar.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

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
		if ((siarmongoTemplate.findById(acidenteSiar.getId(), AcidenteSiar.class, "acidenteSiar")) != null) {
			siarmongoTemplate.save(acidenteSiar, "acidenteSiar");
		}
		siarmongoTemplate.insert(acidenteSiar, "acidenteSiar");
	}
	
	public AcidenteSiar findAcidenteById(String id){
		return siarmongoTemplate.findById(new ObjectId(id), AcidenteSiar.class, "acidenteSiar");
	}
	
	public List<AcidenteSiar> listAcidentes() {
		return siarmongoTemplate.findAll(AcidenteSiar.class, "acidenteSiar");
	}
	
	public void removeAcidente(String id) {
		try {
			ObjectId _id = new ObjectId(id);
			AcidenteSiar acidente = siarmongoTemplate.findById(_id, AcidenteSiar.class, "acidenteSiar");
			siarmongoTemplate.remove(acidente, "acidenteSiar");
		} catch(Exception e) {
			logger.warn("Houve um erro ao remover o acidente indicado", e);
		}
	}
	
}

