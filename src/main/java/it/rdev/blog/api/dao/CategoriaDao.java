/**
 * 
 */
package it.rdev.blog.api.dao;

import org.springframework.data.repository.CrudRepository;

import it.rdev.blog.api.dao.entity.Categoria;

/**
 * @author Anna Eliotropio
 *
 */
public interface CategoriaDao extends CrudRepository<Categoria, Integer>{

	Categoria findByCategoria(String categoria);
}
