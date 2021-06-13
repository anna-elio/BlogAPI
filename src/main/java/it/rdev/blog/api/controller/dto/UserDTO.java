package it.rdev.blog.api.controller.dto;

/**
 * User Transfer Object
 * 
 * @author Danilo Di Nuzzo
 *
 */
public class UserDTO {

	private Integer id;
	private String username;
	private String password;

	/**
	 * Restituisce l'ID dell'utente.
	 * 
	 * @return long che rappresenta l'ID dell'utente.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setta l'ID dell'utente.
	 * 
	 * @param id l'Id da settare.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Restituisce l'username dell'utente.
	 * 
	 * @return String che rappresenta l'username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setta l'username dell'utente.
	 * 
	 * @param username lo username da settare.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Restituisce la password dell'utente.
	 * 
	 * @return String che rappresenta la password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setta la password dell'utente.
	 * 
	 * @param password la password da settare.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}