package br.com.siar.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import br.com.siar.models.AcidenteSiar;

public class AcidenteSiarService extends BasicService {
	
	@Autowired
	private MongoTemplate siarmongoTemplate;
	
	public List<AcidenteSiar> listActiveAcidentes() {
		Query q = queryAtiva(); // TODO
		// Qual a regra que permite ou não a criação de missões no acidente?
		
		return siarmongoTemplate.find(q, AcidenteSiar.class, AcidenteSiar.COLLECTION_NAME);
	}
	
	public AcidenteSiar findAcidenteById(String id){
		return findModelById(AcidenteSiar.class, id);
	}
	
	public List<AcidenteSiar> listAcidentes() {
		return listModels(AcidenteSiar.class);
	}
	
	public void saveAcidente(AcidenteSiar acidenteSiar) {
		saveModel(AcidenteSiar.class, acidenteSiar);
	}
	
	public boolean removeAcidente(String id) {
		
		boolean podeDesativar = true; // TODO
		// Não pode desativar caso haja missões não finalizadas atribuídas a esse acidente
		
		if (podeDesativar) {
			removeModelById(AcidenteSiar.class, id);
		}
		
		return podeDesativar;
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
		return AcidenteSiar.COLLECTION_NAME;
	}

	@Override
	public Logger getLogger() {
		return LoggerFactory.getLogger(this.getClass());
	}
}

