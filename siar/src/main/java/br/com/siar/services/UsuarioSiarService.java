package br.com.siar.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.siar.models.UsuarioSiar;

/**
 * Service created for the CRUD manipulation operations.
 * @author dmarques
 *
 */
public class UsuarioSiarService {

	@Autowired
	private MongoTemplate siarmongoTemplate;
	
	public MongoTemplate getSiarmongoTemplate() {
		return siarmongoTemplate;
	}

	public void setSiarmongoTemplate(MongoTemplate siarmongoTemplate) {
		this.siarmongoTemplate = siarmongoTemplate;
	}

	//Creating an user in the repository.
	public void saveUsuario(UsuarioSiar usuarioSiar) {
		if (!siarmongoTemplate.collectionExists(UsuarioSiar.class)) {
			siarmongoTemplate.createCollection(UsuarioSiar.class);
		}
		
		if(usuarioSiar.getId() == null) {
			siarmongoTemplate.insert(usuarioSiar, "usuarioSiar");
		} else {
			try {
				updateUsuario(usuarioSiar);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Updating the info from an existing user.
	public void updateUsuario(UsuarioSiar usuarioSiar) throws Exception {
		UsuarioSiar existingUser = siarmongoTemplate.findById(usuarioSiar.getId(), UsuarioSiar.class, "usuarioSiar");
		if(existingUser == null) {
			throw new Exception("User not found");
		}
		siarmongoTemplate.save(usuarioSiar, "usuarioSiar");
	}
	
	//Listing the existing users from repository.
	public List<UsuarioSiar> listUsuarios() {
		return siarmongoTemplate.findAll(UsuarioSiar.class, "usuarioSiar");
	}
	
	//Removes an user from the repository.
	public void removeUsuario(String id) throws Exception {
		UsuarioSiar existingUser = siarmongoTemplate.findById(new ObjectId(id), UsuarioSiar.class, "usuarioSiar");
		if(existingUser == null) {
			throw new Exception("User not found");
		}
		siarmongoTemplate.remove(existingUser, "usuarioSiar");
	}
	
	//Finds an user by its id in the repository.
	public UsuarioSiar findUsuarioById(String id){
		return siarmongoTemplate.findById(new ObjectId(id), UsuarioSiar.class, "usuarioSiar");
	}
	
	public UsuarioSiar verify(String email, String senha) {
		
		Query q = new Query();
		q.addCriteria(Criteria.where("email").is(email).and("senha").is(senha));

		System.out.print("Query: " + q + "\nSMT: " + siarmongoTemplate);
		UsuarioSiar user = siarmongoTemplate.findOne(q, UsuarioSiar.class, "usuarioSiar");
		System.out.println("resultado: " + user);
		if (user != null) 
			return user;
		return null;
	}
}
