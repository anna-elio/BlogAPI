/**
 * 
 */
package it.rdev.blog.api.controller.dto;

/**
 * Tag Transfer Object.
 * 
 * @author Anna Eliotropio
 *
 */
public class TagDTO {

	private String tag;

	/**
	 * Restituisce il nome del tag.
	 * 
	 * @return String che rappresenta il tag.
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Setta il nome del tag.
	 * 
	 * @param tag il tag da settare.
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
}
