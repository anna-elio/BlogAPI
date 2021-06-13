/**
 * 
 */
package it.rdev.blog.api.controller.dto;

/**
 * Categora Transfer Object.
 * 
 * @author Anna Eliotropio
 *
 */
public class CategoriaDTO {

	private String categoria;

	/**
	 * Restituisce il nome della categoria.
	 * 
	 * @return String che rappresenta la categoria.
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Setta il nome della categoria.
	 * 
	 * @param categoria la categoria da settare.
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
