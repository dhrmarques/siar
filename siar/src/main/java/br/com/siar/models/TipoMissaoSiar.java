/**
 * 
 */
package br.com.siar.models;


/**
 * @author Leo
 *
 */
public class TipoMissaoSiar extends BasicModel {

	public static final String COLLECTION_NAME = "tipoMissaoSiar";
	
	private String titulo;
	private String descricao;

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
