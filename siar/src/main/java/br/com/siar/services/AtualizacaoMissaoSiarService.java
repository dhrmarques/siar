package br.com.siar.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.siar.models.AtualizacaoMissaoSiar;

/**
 * Service to maintain the recorded data from the missions.
 * @author dmarques
 *
 */
public class AtualizacaoMissaoSiarService {

	private static final String COLLECTION_NAME = "atualizacaoMissaoSiar";
	private static final Logger logger = LoggerFactory.getLogger(AtualizacaoMissaoSiarService.class);
	
	@Autowired
	private MongoTemplate siarmongoTemplate;

	//Getter and setter for MongoTemplate - Required on DispatcherServlet
	public MongoTemplate getSiarmongoTemplate() {
		return siarmongoTemplate;
	}

	public void setSiarmongoTemplate(MongoTemplate siarmongoTemplate) {
		this.siarmongoTemplate = siarmongoTemplate;
	}
	
	//Class methods
	public void saveAtualizacao(AtualizacaoMissaoSiar ams) {
		//If the collection needs to be created
		if(!siarmongoTemplate.collectionExists(AtualizacaoMissaoSiar.class))
			siarmongoTemplate.createCollection(AtualizacaoMissaoSiar.class);
		//If the object already exists in the database - Update
		if(siarmongoTemplate.findById(ams.getId(), AtualizacaoMissaoSiar.class, COLLECTION_NAME) != null)
			siarmongoTemplate.save(ams, COLLECTION_NAME);
		else
			siarmongoTemplate.insert(ams, COLLECTION_NAME);
	}
	
	public AtualizacaoMissaoSiar findAtualizacaoById(String id) {
		return siarmongoTemplate.findById(new ObjectId(id), AtualizacaoMissaoSiar.class, COLLECTION_NAME);
	}
	
	public List<AtualizacaoMissaoSiar> listarAtualizacoes() {
		return siarmongoTemplate.findAll(AtualizacaoMissaoSiar.class, COLLECTION_NAME);
	}
	
	//TODO - Remove(?)
	
}
