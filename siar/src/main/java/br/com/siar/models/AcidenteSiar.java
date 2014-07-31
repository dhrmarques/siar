package br.com.siar.models;


public class AcidenteSiar extends BasicModel {
	
	public static final String COLLECTION_NAME = "acidenteSiar";

	public String descricao;
	public String prioridade;
	
	public AcidenteSiar() {
		
	}
	
	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
