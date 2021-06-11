/**
 * 
 */
package it.rdev.blog.api.dao;

import org.springframework.data.repository.CrudRepository;

import it.rdev.blog.api.dao.entity.Articolo;

/**
 * @author Anna Eliotropio
 *
 */
public interface ArticoloDao extends CrudRepository<Articolo, Integer> {

	Articolo findByTitolo(String titolo);
}
