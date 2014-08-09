/**
 * 
 */
package br.com.siar.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * @author Leo
 *
 */
public abstract class BasicModel implements Comparable<BasicModel> {

	@Id
	private ObjectId _id;
	
	private Boolean ativo;

	public ObjectId getId() {
		return _id;
	}
	
	public void setId(ObjectId id) {
		_id = id;
	}
	
	public Date getDataCriacao() {
		return new Date(_id.getTime());
	}
	
	public String getDataCriacao1() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		return sdf.format(getDataCriacao());
	}
	
	public String getDataCriacao2() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-EEE-YYYY");
		return sdf.format(getDataCriacao());
	}
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int compareTo(BasicModel model) {
		
		return this.getDataCriacao().compareTo(model.getDataCriacao());
	}
}
