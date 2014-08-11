/**
 * 
 */
package br.com.siar.services;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.siar.models.AcidenteSiar;
import br.com.siar.models.MissaoSiar;
import br.com.siar.models.StatusMissao;
import br.com.siar.models.TipoMissaoSiar;
import br.com.siar.models.UsuarioSiar;
import br.com.siar.models.response.MissaoResponse;

/**
 * @author Leo
 *
 */
public class MissaoSiarService extends BasicService {
	
	private static final String COLLECTION_NAME = MissaoSiar.COLLECTION_NAME;

	@Autowired
	private MongoTemplate siarmongoTemplate;
	
	public List<MissaoResponse> listMissoesPendentes() {

		Query q = new Query(Criteria.where("status").is(StatusMissao.PENDENTE));
		List<MissaoSiar> missoes = siarmongoTemplate.find(q, MissaoSiar.class, getCollectionName());
		
		List<MissaoResponse> responseList = new ArrayList<MissaoResponse>();
		for (MissaoSiar missao : missoes) {
			responseList.add(responseFromModel(missao));
		}
		
		return responseList;
	}
	
	public MissaoResponse findMissaoById(String id){
		
		MissaoSiar missao = findModelById(MissaoSiar.class, id);
		return responseFromModel(missao);
	}
	
	public List<MissaoResponse> listMissoes() {
		
		List<MissaoResponse> lista = new ArrayList<MissaoResponse>();
		List<MissaoSiar> missoes = listModels(MissaoSiar.class);
		
		for (MissaoSiar missao : missoes) {
			lista.add(responseFromModel(missao));
		}
		
		return lista; 
	}
	
	public ObjectId saveMissao(MissaoSiar missao) {
		saveModel(MissaoSiar.class, missao);
		
		Query q = new Query();
		q.addCriteria(Criteria.where("acidenteId").is(missao.getAcidenteId()));
		q.with(new Sort(Direction.DESC, "_id")); // Mais recente
		
		return siarmongoTemplate.findOne(q, MissaoSiar.class, getCollectionName()).getId();
	}
	
	private MissaoResponse responseFromModel(MissaoSiar missao) {
		
		return new MissaoResponse(missao,
				siarmongoTemplate.findById(missao.getAcidenteId(), AcidenteSiar.class),
				siarmongoTemplate.findById(missao.getTipoMissaoId(), TipoMissaoSiar.class),
				siarmongoTemplate.findById(missao.getChefeId(), UsuarioSiar.class));
	}
	
	public void removeMissao(String id) {
		// TODO check if it CAN be removed
		removeModelById(MissaoSiar.class, id);
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
