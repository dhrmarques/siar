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
	private String statusMissaoId;

	private String detalhes;
	
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

	public String getStatusMissaoId() {
		return statusMissaoId;
	}

	public void setStatusMissaoId(String statusMissaoId) {
		this.statusMissaoId = statusMissaoId;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
}
