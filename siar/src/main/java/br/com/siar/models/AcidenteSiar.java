package br.com.siar.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class AcidenteSiar {
	
	@Id
	private ObjectId _id;

	public String descricao;
	public String prioridade;
	
	public AcidenteSiar() {
		
	}
	
	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId _id) {
		this._id = _id;
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
