/**
 * 
 */
package br.com.siar.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.siar.models.AcidenteSiar;
import br.com.siar.models.MissaoSiar;
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
	
	public MissaoResponse findMissaoById(String id){
		
		MissaoSiar missao = findModelById(MissaoSiar.class, id);
		MissaoResponse response = new MissaoResponse(missao,
				siarmongoTemplate.findById(missao.getAcidenteId(), AcidenteSiar.class, AcidenteSiar.COLLECTION_NAME),
				siarmongoTemplate.findById(missao.getTipoMissaoId(), TipoMissaoSiar.class, TipoMissaoSiar.COLLECTION_NAME),
				siarmongoTemplate.findById(missao.getChefeId(), UsuarioSiar.class, UsuarioSiar.COLLECTION_NAME));
		
		return response;
	}
	
	public List<MissaoResponse> listMissoes() {
		
		List<MissaoResponse> lista = new ArrayList<MissaoResponse>();
		List<MissaoSiar> missoes = listModels(MissaoSiar.class);
		
		for (MissaoSiar missao : missoes) {
			lista.add(new MissaoResponse(missao,
					siarmongoTemplate.findById(missao.getAcidenteId(), AcidenteSiar.class),
					siarmongoTemplate.findById(missao.getTipoMissaoId(), TipoMissaoSiar.class),
					siarmongoTemplate.findById(missao.getChefeId(), UsuarioSiar.class)));
		}
		
		return lista; 
	}
	
	public void saveMissao(MissaoSiar missao) {
		saveModel(MissaoSiar.class, missao);
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
