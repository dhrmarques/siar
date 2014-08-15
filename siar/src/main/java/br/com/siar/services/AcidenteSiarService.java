package br.com.siar.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.siar.models.AcidenteSiar;
import br.com.siar.models.BasicModel;
import br.com.siar.models.TipoMissaoSiar;

public class AcidenteSiarService extends BasicService {
	
	@Autowired
	private MongoTemplate siarmongoTemplate;
	
	public List<AcidenteSiar> listActiveAcidentes() {
		Query q = queryAtiva();
		q.addCriteria(Criteria.where("prioridade").is("Baixa")); // TODO
		
		return siarmongoTemplate.find(q, AcidenteSiar.class, AcidenteSiar.COLLECTION_NAME);
	}
	
	public AcidenteSiar findAcidenteById(String id){
		return findModelById(AcidenteSiar.class, id);
	}
	
	public TipoMissaoSiar findAcidenteByDescricao(String descricao) {
		Query q = new Query(Criteria.where("descricao").is(descricao));
		return getSiarmongoTemplate().findOne(q, TipoMissaoSiar.class, getCollectionName());
	}
	
	
	public List<AcidenteSiar> listAcidentes() {
		return listModels(AcidenteSiar.class);
	}
	
	public void saveAcidente(AcidenteSiar acidenteSiar) {
		saveModel(AcidenteSiar.class, acidenteSiar);
	}
	
	public void removeAcidente(String id) {
		// TODO check if it CAN be removed
		removeModelById(AcidenteSiar.class, id);
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

