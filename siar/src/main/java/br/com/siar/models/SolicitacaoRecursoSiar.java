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
	
	public SolicitacaoRecursoSiar(String necessidadeId, String fornecedorId, int qtd) {
		this.necessidadeId = new ObjectId(necessidadeId);
		this.fornecedorId = new ObjectId(fornecedorId);
		this.quantidade = qtd;
	}
	
	public static final String COLLECTION_NAME = "solicitacaoRecursoSiar";
	
	private ObjectId necessidadeId;
	private ObjectId fornecedorId;
	private int quantidade;

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
