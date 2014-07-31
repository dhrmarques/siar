package br.com.siar.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Class created to keep records of the mission status changes.
 * @author dmarques
 *
 */
public class AtualizacaoMissaoSiar {

	@Id
	private ObjectId _id;
	
	private Date dataAtualizacao;
	private ObjectId missaoId;
	private String comentario;
	private ObjectId usuarioId;
	
	
	public ObjectId getId() {
		return _id;
	}
	public void setId(ObjectId _id) {
		this._id = _id;
	}
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public ObjectId getMissaoId() {
		return missaoId;
	}
	public void setMissaoId(ObjectId missaoId) {
		this.missaoId = missaoId;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public ObjectId getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(ObjectId usuarioId) {
		this.usuarioId = usuarioId;
	}
	
}
