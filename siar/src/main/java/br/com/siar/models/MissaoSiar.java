/**
 * 
 */
package br.com.siar.models;

import org.bson.types.ObjectId;

/**
 * @author Leo
 *
 */
public class MissaoSiar extends BasicModel {

	public static final String COLLECTION_NAME = "missaoSiar";
	
	private ObjectId acidenteId;
	private ObjectId tipoMissaoId;
	private StatusMissao status;
	private ObjectId chefeId;

	private String detalhes;
	
	public ObjectId getAcidenteId() {
		return acidenteId;
	}

	public void setAcidenteId(ObjectId acidenteId) {
		this.acidenteId = acidenteId;
	}

	public ObjectId getTipoMissaoId() {
		return tipoMissaoId;
	}

	public void setTipoMissaoId(ObjectId tipoMissaoId) {
		this.tipoMissaoId = tipoMissaoId;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
<<<<<<< HEAD
	public void setStatus(boolean status){
		this.status = status;
	}
=======

	public StatusMissao getStatus() {
		return status;
	}

	public void setStatus(StatusMissao status) {
		this.status = status;
	}

	public ObjectId getChefeId() {
		return chefeId;
	}

	public void setChefeId(ObjectId chefeId) {
		this.chefeId = chefeId;
	}
>>>>>>> 72378476597035016ac8e7a119eb79a678d1e934
}
