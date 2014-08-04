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
public class MissaoSiar {

	@Id
	private ObjectId _id;
	
	private String acidenteId;
	private String tipoMissaoId;

	private String detalhes;
	private boolean status;
	
	public boolean getStatus(){
		return status;
	}
	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId id) {
		this._id = id;
	}

	public String getAcidenteId() {
		return acidenteId;
	}

	public void setAcidenteId(String acidenteId) {
		this.acidenteId = acidenteId;
	}

	public String getTipoMissaoId() {
		return tipoMissaoId;
	}

	public void setTipoMissaoId(String tipoMissaoId) {
		this.tipoMissaoId = tipoMissaoId;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	public void setStatus(boolean status){
		this.status = status;
	}
}
