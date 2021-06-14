/**
 * 
 */
package it.rdev.blog.api.service;

import java.util.List;

import it.rdev.blog.api.controller.dto.ArticoloDTO;
import it.rdev.blog.api.dao.entity.Articolo;

/**
 * @author Anna Eliotropio
 *
 */
public interface ArticoloDetailService {

	public List<Articolo> findAll();

	/**
	 * Trova l'articolo identificato identificato dall'ID.
	 * 
	 * @param id l'ID dell'articolo da trovare.
	 * @return l'articolo trovato.
	 */
	public Articolo findById(Integer id);

	/**
	 * Salva l'articolo specificato (in versione bozza) nel database, associandolo
	 * all'utente indicato da {@code idUser}.
	 * 
	 * @param articolo l'articlo da salvare.
	 * @param idUser   l'ID dell'utente a cui associare l'articolo
	 * @return {@code true} se il salvataggio va a buon fine, {@code false}
	 *         altrimenti
	 */
	public boolean save(ArticoloDTO articolo, Long idUser);

	public Articolo update(ArticoloDTO articolo);

	public Articolo delete(Integer id);
}
