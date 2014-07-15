package br.com.siar.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.siar.models.UsuarioSiar;

/**
 * Service created for the CRUD manipulation operations.
 * @author dmarques
 *
 */
public class UsuarioService {

	@Autowired
	private MongoTemplate siarmongoTemplate;
	
	//Creating an user in the repository.
	public void createUsuario(UsuarioSiar usuarioSiar) {
		if (!siarmongoTemplate.collectionExists(UsuarioSiar.class)) {
			siarmongoTemplate.createCollection(UsuarioSiar.class);
		}
		siarmongoTemplate.insert(usuarioSiar, "usuarioSiarTable");
	}
	
	//Updating the info from an existing user.
	public void updateUsuario(UsuarioSiar usuarioSiar) throws Exception {
		UsuarioSiar existingUser = siarmongoTemplate.findById(usuarioSiar.getId(), UsuarioSiar.class, "usuarioSiarTable");
		if(existingUser == null) {
			throw new Exception("User not found");
		}
		siarmongoTemplate.save(usuarioSiar, "usuarioSiarTable");
	}
	
	//Listing the existing users from repository.
	public List<UsuarioSiar> listUsuarios() {
		return siarmongoTemplate.findAll(UsuarioSiar.class, "usuarioSiarTable");
	}
	
	//Removes an user from the repository.
	public void removeUsuario(String id) throws Exception {
		UsuarioSiar existingUser = siarmongoTemplate.findById(new ObjectId(id), UsuarioSiar.class, "usuarioSiarTable");
		if(existingUser == null) {
			throw new Exception("User not found");
		}
		siarmongoTemplate.remove(existingUser, "usuarioSiarTable");
	}
	
}
