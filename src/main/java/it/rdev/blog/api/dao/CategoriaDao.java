/**
 * 
 */
package it.rdev.blog.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.rdev.blog.api.dao.entity.Categoria;

/**
 * Interfaccia repository. Contiene le query da eseguire sul repository.
 * 
 * @author Anna Eliotropio
 *
 */
@Repository
public interface CategoriaDao extends CrudRepository<Categoria, Integer>{

	/**
	 * Cerca la categoria passata in input.
	 * 
	 * @param categoria la categoria da cercare.
	 * @return la {@link Categoria} corrispondente.
	 */
	Categoria findByCategoria(String categoria);
}
