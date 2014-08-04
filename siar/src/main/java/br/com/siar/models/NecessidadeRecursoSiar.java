/**
 * 
 */
package br.com.siar.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * @author Leo
 *
 */
public class NecessidadeRecursoSiar extends BasicModel {
	
	public static final String COLLECTION_NAME = "necessidadeRecursoSiar";

	@Id
	private ObjectId _id;
	
	private ObjectId recursoId;
	private ObjectId missaoId;
	private int quantidadeTotal;
	
	public ObjectId getId() {
		return _id;
	}
	public void setId(ObjectId id) {
		this._id = id;
	}
	public ObjectId getRecursoId() {
		return recursoId;
	}
	public void setRecursoId(ObjectId recursoId) {
		this.recursoId = recursoId;
	}
	public ObjectId getMissaoId() {
		return missaoId;
	}
	public void setMissaoId(ObjectId missaoId) {
		this.missaoId = missaoId;
	}
	public int getQuantidadeTotal() {
		return quantidadeTotal;
	}
	public void setQuantidadeTotal(int quantidade) {
		this.quantidadeTotal = quantidade;
	}
}
