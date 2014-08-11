package br.com.siar.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.siar.models.UsuarioSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;

/**
 * Service created for the CRUD manipulation operations.
 * @author dmarques
 *
 */
public class UsuarioSiarService extends BasicService {

	@Autowired
	private MongoTemplate siarmongoTemplate;
	
	//Finds an user by its id in the repository.
	public UsuarioSiar findUsuarioById(String id){
		return findModelById(UsuarioSiar.class, id);
	}

	//Updating the info from an existing user.
	public void updateUsuario(UsuarioSiar usuarioSiar) throws Exception {
		UsuarioSiar existingUser = siarmongoTemplate.findById(usuarioSiar.getId(), UsuarioSiar.class, UsuarioSiar.COLLECTION_NAME);
		if(existingUser == null) {
			throw new Exception("User not found");
		}
		siarmongoTemplate.save(usuarioSiar, UsuarioSiar.COLLECTION_NAME);
	}
	
	//Listing the existing users from repository.
	public List<UsuarioSiar> listUsuarios() {
		return listModels(UsuarioSiar.class);
	}
	
	public List<UsuarioSiar> listChefesDeMissao() {
		
		Query q = queryAtiva();
		q.addCriteria(Criteria.where("tipoUsuario").is(TipoUsuario.CHEFE_MISSAO));
		List<UsuarioSiar> chefes = siarmongoTemplate.find(q, UsuarioSiar.class, getCollectionName());
		
		return chefes;
	}
	
	//Creating an user in the repository.
	public void saveUsuario(UsuarioSiar usuarioSiar) {
		saveModel(UsuarioSiar.class, usuarioSiar);
	}
	
	//Removes an user from the repository.
	public void removeUsuario(String id) {
		// TODO check if it CAN be removed
		removeModelById(UsuarioSiar.class, id);
	}
	
	public UsuarioSiar verify(String email, String senha) {
		
		Query q = queryAtiva();
		q.addCriteria(Criteria.where("email").is(email).and("senha").is(senha));

		System.out.print("Query: " + q + "\nSMT: " + siarmongoTemplate);
		UsuarioSiar user = siarmongoTemplate.findOne(q, UsuarioSiar.class, UsuarioSiar.COLLECTION_NAME);
		System.out.println("resultado: " + user);
		if (user != null) 
			return user;
		return null;
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
		return UsuarioSiar.COLLECTION_NAME;
	}

	@Override
	public Logger getLogger() {
		return LoggerFactory.getLogger(this.getClass());
	}
}
