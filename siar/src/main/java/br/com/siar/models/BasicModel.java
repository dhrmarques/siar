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
public abstract class BasicModel {

	@Id
	private ObjectId _id;
	
	public ObjectId getId() {
		return _id;
	}
	
	public void setId(ObjectId id) {
		_id = id;
	}
}
