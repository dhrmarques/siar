package br.com.siar.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Class created to save info about the external suppliers.
 * @author dmarques
 *
 */
public class FornecedorSiar {

	@Id
	private ObjectId _id;
	
	private String nome;
	private String urlSolicitacao;
	
	public ObjectId getId() {
		return _id;
	}
	public void setId(ObjectId _id) {
		this._id = _id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrlSolicitacao() {
		return urlSolicitacao;
	}
	public void setUrlSolicitacao(String urlSolicitacao) {
		this.urlSolicitacao = urlSolicitacao;
	}
	
}
