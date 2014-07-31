/**
 * 
 */
package br.com.siar.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.siar.models.TipoMissaoSiar;

/**
 * @author Leo
 *
 */
public class TipoMissaoSiarService {
	
	private static final String COLLECTION_NAME = TipoMissaoSiar.COLLECTION_NAME;

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
	
	// Service methods
	public void saveTipoMissao(TipoMissaoSiar tipo) {
		if (!siarmongoTemplate.collectionExists(TipoMissaoSiar.class)) {
			siarmongoTemplate.createCollection(TipoMissaoSiar.class);
		}
		//Checking if the object already exists
		if ((siarmongoTemplate.findById(tipo.getId(), TipoMissaoSiar.class, COLLECTION_NAME)) != null) {
			siarmongoTemplate.save(tipo, COLLECTION_NAME);
		}
		siarmongoTemplate.insert(tipo, COLLECTION_NAME);
	}
	
	public TipoMissaoSiar findTipoMissaoById(String id){
		return siarmongoTemplate.findById(new ObjectId(id), TipoMissaoSiar.class, COLLECTION_NAME);
	}
	
	public List<TipoMissaoSiar> listTiposMissao() {
		List<TipoMissaoSiar> list = siarmongoTemplate.findAll(TipoMissaoSiar.class, COLLECTION_NAME);
		return list;
	}
	
	public void removeTipoMissao(String id) {
		try {
			ObjectId _id = new ObjectId(id);
			TipoMissaoSiar tipo = siarmongoTemplate.findById(_id, TipoMissaoSiar.class, COLLECTION_NAME);
			siarmongoTemplate.remove(tipo, COLLECTION_NAME);
		} catch(Exception e) {
			logger.warn("Houve um erro ao remover o tipo de missão indicado", e);
		}
	}
}
