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

	public Articolo findById(Integer id);

	public boolean save(ArticoloDTO articolo, Long idUser);
	
	public Articolo update(ArticoloDTO articolo);
	
	public Articolo delete(Integer id);
}
