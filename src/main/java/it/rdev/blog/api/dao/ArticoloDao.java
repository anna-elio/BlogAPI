/**
 * 
 */
package it.rdev.blog.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.rdev.blog.api.dao.entity.Articolo;

/**
 * Interfaccia repository. Contiene le query da eseguire sul repository.
 * 
 * @author Anna Eliotropio
 *
 */
@Repository
public interface ArticoloDao extends CrudRepository<Articolo, Integer> {

	/**
	 * Cerca l'articolo tramite il suo titolo.
	 * 
	 * @param titolo il titolo da ricercare.
	 * @return l'{@link Articolo} corrispondente al titolo.
	 */
	Articolo findByTitolo(String titolo);
}
