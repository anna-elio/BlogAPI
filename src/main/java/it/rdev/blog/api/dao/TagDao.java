/**
 * 
 */
package it.rdev.blog.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.rdev.blog.api.dao.entity.Tag;

/**
 * Interfaccia repository. Contiene le query da eseguire sul repository.
 * 
 * @author Anna Eliotropio
 *
 */
@Repository
public interface TagDao extends CrudRepository<Tag, Integer>{

	/**
	 * Cerca il tag passato in input.
	 * 
	 * @param tag il tag da cercare.
	 * @return il {@link Tag} corrispondente.
	 */
	Tag findByTag(String tag);
}
