/**
 * 
 */
package br.com.siar.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.siar.models.TipoMissaoSiar;

/**
 * @author Leo
 *
 */
public class TipoMissaoSiarService extends BasicService {
	
	private static final String COLLECTION_NAME = TipoMissaoSiar.COLLECTION_NAME;

	@Autowired
	private MongoTemplate siarmongoTemplate;

	public TipoMissaoSiar findTipoMissaoById(String id){
		return findModelById(TipoMissaoSiar.class, id);
	}
	
	public List<TipoMissaoSiar> listTiposMissao() {
		return listModels(TipoMissaoSiar.class);
	}

	public void saveTipoMissao(TipoMissaoSiar tipo) {
		saveModel(TipoMissaoSiar.class, tipo);
	}
	
	public void removeTipoMissao(String id) {
		// TODO check if it CAN be removed
		removeModelById(TipoMissaoSiar.class, id);
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
		return LoggerFactory.getLogger(this.getClass());
	}
}
