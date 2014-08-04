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
public class SolicitacaoRecursoSiar extends BasicModel {
	
	public static final String COLLECTION_NAME = "solicitacaoRecursoSiar";

	@Id
	private ObjectId _id;
	
	private ObjectId necessidadeId;
	private ObjectId fornecedorId;
	private int quantidade;
	
	public ObjectId getId() {
		return _id;
	}
	public void setId(ObjectId id) {
		this._id = id;
	}
	public ObjectId getNecessidadeId() {
		return necessidadeId;
	}
	public void setNecessidadeId(ObjectId necessidadeId) {
		this.necessidadeId = necessidadeId;
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
