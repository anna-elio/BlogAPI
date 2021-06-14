/**
 * 
 */
package it.rdev.blog.api.service;

import java.util.Set;

import it.rdev.blog.api.controller.dto.CategoriaDTO;
import it.rdev.blog.api.dao.entity.Categoria;

/**
 * 
 * @author Anna Eliotropio
 *
 */
public interface CategoriaDetailService {

	/**
	 * Cerca tutte le categorie presenti nel database.
	 * 
	 * @return l'insieme delle categorie trovate.
	 */
	public Set<CategoriaDTO> findAll();
	
	/**
	 * Salva la categoria specificata nel database.
	 * 
	 * @param categoria la categoria da salvare.
	 * @return l'entità salvata.
	 */
	Categoria save(CategoriaDTO categoria);
	/**
	 * Cerca nel database la categoria specificata.
	 * @param categoria la categoria da cercare.
	 * @return CategoriaDTO il transfer object che rappresenta la categoria
	 */
	public Categoria findByName(String categoria);
}
