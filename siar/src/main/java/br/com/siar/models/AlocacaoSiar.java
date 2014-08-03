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
public class AlocacaoSiar extends BasicModel {

	@Id
	private ObjectId _id;
	
	private ObjectId recursoId;
	private ObjectId missaoId;
	private ObjectId fornecedorId;
	private int quantidade;
	
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
	public ObjectId getFornecedorId() {
		return fornecedorId;
	}
	public void setFornecedorId(ObjectId fornecedorId) {
		this.fornecedorId = fornecedorId;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
