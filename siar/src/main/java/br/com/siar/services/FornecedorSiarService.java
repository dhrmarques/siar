package br.com.siar.services;

import java.util.List;

import org.bson.types.ObjectId;
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
public class FornecedorSiarService {

	@Autowired
	private MongoTemplate siarmongoTemplate;
	
	private static final String COLLECTION_NAME = "fornecedorSiar";
	private static final Logger logger = LoggerFactory.getLogger(FornecedorSiarService.class);
	
	//Getter and setter for the MongoTemplate - Required
	public MongoTemplate getSiarmongoTemplate() {
		return siarmongoTemplate;
	}
	
	public void setSiarmongoTemplate(MongoTemplate siarmongoTemplate) {
		this.siarmongoTemplate = siarmongoTemplate;
	}
	
	//Class methods
		public void saveFornecedor(FornecedorSiar fornecedor) {
			//If the collection needs to be created
			if(!siarmongoTemplate.collectionExists(FornecedorSiar.class))
				siarmongoTemplate.createCollection(FornecedorSiar.class);
			//If the object already exists in the database - Update
			if(siarmongoTemplate.findById(fornecedor.getId(), FornecedorSiar.class, COLLECTION_NAME) != null)
				siarmongoTemplate.save(fornecedor, COLLECTION_NAME);
			else
				siarmongoTemplate.insert(fornecedor, COLLECTION_NAME);
		}
		
		public FornecedorSiar findFornecedorById(String id) {
			return siarmongoTemplate.findById(new ObjectId(id), FornecedorSiar.class, COLLECTION_NAME);
		}
		
		public List<FornecedorSiar> listarFornecedores() {
			return siarmongoTemplate.findAll(FornecedorSiar.class, COLLECTION_NAME);
		}
		
		public void removeFornecedor(String id) {
			try {
				ObjectId _id = new ObjectId(id);
				FornecedorSiar fornecedor = siarmongoTemplate.findById(_id, FornecedorSiar.class, COLLECTION_NAME);
				siarmongoTemplate.remove(fornecedor, COLLECTION_NAME);
			} catch(Exception e) {
				logger.warn("Houve um erro ao remover o recurso indicado", e);
			}
		}
}
