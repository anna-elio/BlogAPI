package it.rdev.blog.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.rdev.blog.api.dao.entity.User;

/**
 * 
 * @author Danilo Di Nuzzo
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	/**
	 * Cerca l'utente in base al suo username.
	 * 
	 * @param username lo username da cercare.
	 * @return lo {@link User} corrispondente.
	 */
	User findByUsername(String username);
	
}