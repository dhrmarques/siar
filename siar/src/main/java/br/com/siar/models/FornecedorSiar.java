package br.com.siar.models;


/**
 * Class created to save info about the external suppliers.
 * @author dmarques
 *
 */
public class FornecedorSiar extends BasicModel {
	
	public static final String COLLECTION_NAME = "fornecedorSiar";

	private String nome;
	private String urlSolicitacao;
	
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
