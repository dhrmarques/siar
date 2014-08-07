package br.com.siar.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.siar.models.UsuarioSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;

public class StartupService extends BasicService {

	@Autowired
	MongoTemplate siarmongoTemplate;
	
	public void createFirstAdmin() {
		
		UsuarioSiar alpha = new UsuarioSiar();
		alpha.setEmail("arceus");
		alpha.setNome("Alpha Omega");
		alpha.setSenha("1234");
		alpha.setCpf("201.411.213-86");
		alpha.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
		alpha.setAtivo(true);
		
		String collectionName = UsuarioSiar.COLLECTION_NAME;
		if (!siarmongoTemplate.collectionExists(collectionName)) {
			siarmongoTemplate.createCollection(collectionName);
		}
		siarmongoTemplate.save(alpha, collectionName);
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
		return null;
	}

	@Override
	protected Logger getLogger() {
		return LoggerFactory.getLogger(this.getClass());
	}

}
