/**
 * 
 */
package br.com.siar.utils;

/**
 * @author Leo
 *
 */
public class Link {
	
	public Link(String label, String path) {
		this.label = label;
		this.path = path;
	}
	
	private String label;
	private String path;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
