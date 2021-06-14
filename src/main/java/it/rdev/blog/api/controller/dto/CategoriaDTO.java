/**
 * 
 */
package it.rdev.blog.api.controller.dto;

/**
 * Categoria Transfer Object.
 * 
 * @author Anna Eliotropio
 *
 */
public class CategoriaDTO {

	private long id;
	private String categoria;

	/**
	 * Restituisce l'ID della categoria.
	 * 
	 * @return long id che identifica la categoria.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Setta l'ID della categoria.
	 * 
	 * @param id l'ID da settare.
	 */
	public void setId(long id) {
		this.id = id;
	}
	
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
