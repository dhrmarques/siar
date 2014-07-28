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
public class RecursoSiar {

	@Id
	private ObjectId _id;
	
	private boolean recursoHumano;
	private String nome;
	private int qtdPropria;
	private String descricao;
	
	public RecursoSiar() {
		
	}
	
	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId _id) {
		this._id = _id;
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
