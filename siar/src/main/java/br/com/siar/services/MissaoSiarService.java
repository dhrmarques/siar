/**
 * 
 */
package br.com.siar.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.siar.models.AcidenteSiar;
import br.com.siar.models.MissaoSiar;
import br.com.siar.models.TipoMissaoSiar;
import br.com.siar.models.response.MissaoResponse;

/**
 * @author Leo
 *
 */
public class MissaoSiarService {
	
	private static final String COLLECTION_NAME = "missaoSiar";

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
	public void saveMissao(MissaoSiar missao) {
		if (!siarmongoTemplate.collectionExists(MissaoSiar.class)) {
			siarmongoTemplate.createCollection(MissaoSiar.class);
		}
		//Checking if the object already exists
		if ((siarmongoTemplate.findById(missao.getId(), MissaoSiar.class, COLLECTION_NAME)) != null) {
			siarmongoTemplate.save(missao, COLLECTION_NAME);
		}
		siarmongoTemplate.insert(missao, COLLECTION_NAME);
	}
	
	public MissaoResponse findMissaoById(String id){
		
		MissaoSiar missao = siarmongoTemplate.findById(new ObjectId(id), MissaoSiar.class, COLLECTION_NAME);
		MissaoResponse response = new MissaoResponse(missao,
				siarmongoTemplate.findById(missao.getAcidenteId(), AcidenteSiar.class),
				siarmongoTemplate.findById(missao.getTipoMissaoId(), TipoMissaoSiar.class));
		
		return response;
	}
	
	public List<MissaoResponse> listMissoes() {
		
		List<MissaoResponse> lista = new ArrayList<MissaoResponse>();
		List<MissaoSiar> missoes = siarmongoTemplate.findAll(MissaoSiar.class, COLLECTION_NAME);
		for (MissaoSiar missao : missoes) {
			lista.add(new MissaoResponse(missao,
					siarmongoTemplate.findById(missao.getAcidenteId(), AcidenteSiar.class),
					siarmongoTemplate.findById(missao.getTipoMissaoId(), TipoMissaoSiar.class)));
		}		
		
		return lista; 
	}
	
	public void removeMissao(String id) {
		try {
			ObjectId _id = new ObjectId(id);
			MissaoSiar missao = siarmongoTemplate.findById(_id, MissaoSiar.class, COLLECTION_NAME);
			siarmongoTemplate.remove(missao, COLLECTION_NAME);
		} catch(Exception e) {
			logger.warn("Houve um erro ao remover a missão indicada", e);
		}
	}
}
