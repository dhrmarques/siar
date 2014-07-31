/**
 * 
 */
package br.com.siar.models;


/**
 * @author Leo
 *
 */
public class RecursoSiar extends BasicModel {

	public static final String COLLECTION_NAME = "missaoSiar";
	
	private boolean recursoHumano;
	private String nome;
	private int qtdPropria;
	private String descricao;
	
	public RecursoSiar() {
		
	}

	public boolean isRecursoHumano() {
		return recursoHumano;
	}

	public void setRecursoHumano(boolean isRecursoHumano) {
		this.recursoHumano = isRecursoHumano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdPropria() {
		return qtdPropria;
	}

	public void setQtdPropria(int qtdPropria) {
		this.qtdPropria = qtdPropria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
