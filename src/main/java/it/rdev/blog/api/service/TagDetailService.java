/**
 * 
 */
package it.rdev.blog.api.service;

import java.util.Set;

import it.rdev.blog.api.controller.dto.TagDTO;
import it.rdev.blog.api.dao.entity.Tag;

/**
 * @author Anna Eliotropio
 *
 */
public interface TagDetailService {

	/**
	 * Cerca tutti i tag presenti nel database.
	 * 
	 * @return l'insieme dei tag trovati.
	 */
	public Set<TagDTO> findAll();

	/**
	 * Salva il tag spacificato nel database.
	 * 
	 * @param tag il tag da salvare.
	 * @return l'entità salvata.
	 */
	Tag save(TagDTO tag);

}
