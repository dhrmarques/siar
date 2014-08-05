package br.com.siar.models;

import org.bson.types.ObjectId;

/**
 * Class created to keep records of the mission status changes.
 * @author dmarques
 *
 */
public class AtualizacaoMissaoSiar extends BasicModel {
	
	public static final String COLLECTION_NAME = "atualizacaoMissaoSiar";
	
	private ObjectId missaoId;
	private String comentario;
	private ObjectId usuarioId;
	private StatusMissao status;

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
	public StatusMissao getStatus() {
		return status;
	}
	public void setStatus(StatusMissao status) {
		this.status = status;
	}
	
}
