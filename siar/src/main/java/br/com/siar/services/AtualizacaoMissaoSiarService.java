package br.com.siar.services;

import java.util.List;

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
public class AtualizacaoMissaoSiarService extends BasicService {

	private static final String COLLECTION_NAME = AtualizacaoMissaoSiar.COLLECTION_NAME;
	
	@Autowired
	private MongoTemplate siarmongoTemplate;
	
	public void saveAtualizacao(AtualizacaoMissaoSiar ams) {
		saveModel(AtualizacaoMissaoSiar.class, ams);
	}
	
	public AtualizacaoMissaoSiar findAtualizacaoById(String id) {
		return findModelById(AtualizacaoMissaoSiar.class, id);
	}
	
	public List<AtualizacaoMissaoSiar> listarAtualizacoes() {
		return siarmongoTemplate.findAll(AtualizacaoMissaoSiar.class, COLLECTION_NAME);
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
		return COLLECTION_NAME;
	}

	@Override
	protected Logger getLogger() {
		return LoggerFactory.getLogger(this.getClass());
	}
}
