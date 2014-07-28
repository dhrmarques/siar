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
public class TipoMissaoSiar {
	
	@Id
	private ObjectId _id;
	
	private String titulo;
	private String descricao;

	public ObjectId getId() {
		return _id;
	}
	public void setId(ObjectId id) {
		this._id = id;
	}
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
