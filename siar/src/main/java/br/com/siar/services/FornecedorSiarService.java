package br.com.siar.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.siar.models.FornecedorSiar;

/**
 * Service to maintain the data about the suppliers.
 * @author dmarques
 *
 */
public class FornecedorSiarService extends BasicService {

	@Autowired
	private MongoTemplate siarmongoTemplate;
	
	private static final String COLLECTION_NAME = FornecedorSiar.COLLECTION_NAME;
	private static final Logger logger = LoggerFactory.getLogger(FornecedorSiarService.class);
	
	
	public FornecedorSiar findFornecedorById(String id) {
		return findModelById(FornecedorSiar.class, id);
	}
	
	public List<FornecedorSiar> listarFornecedores() {
		return listModels(FornecedorSiar.class);
	}
	
	public void saveFornecedor(FornecedorSiar fornecedor) {
		saveModel(FornecedorSiar.class, fornecedor);
	}
	
	public void removeFornecedor(String id) {
		// TODO check if it CAN be removed
		removeModelById(FornecedorSiar.class, id);
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
		return COLLECTION_NAME;
	}

	@Override
	public Logger getLogger() {
		return logger;
	}
}
