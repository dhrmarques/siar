package br.com.siar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.siar.models.AcidenteSiar;

public class AcidenteSiarService {
	@Autowired
	private MongoTemplate customermongoTemplate;
	public void saveAcidente(AcidenteSiar acidenteSiar) {
		if (!customermongoTemplate.collectionExists(AcidenteSiar.class)) {
			customermongoTemplate.createCollection(AcidenteSiar.class);
		}
		customermongoTemplate.insert(acidenteSiar, "acidenteSiarTable");
	}
	public List<AcidenteSiar> listAcidentes() {
		return customermongoTemplate.findAll(AcidenteSiar.class, "acidenteSiarTable");
	}
	
}

