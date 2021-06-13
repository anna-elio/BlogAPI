/**
 * 
 */
package it.rdev.blog.api.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rdev.blog.api.controller.dto.CategoriaDTO;
import it.rdev.blog.api.dao.CategoriaDao;
import it.rdev.blog.api.dao.entity.Categoria;

/**
 * @author Anna Eliotropio
 *
 */
@Service
public class BlogCategoriaDetailService {

	@Autowired
	private CategoriaDao catDao;
	
	/**
	 * Cerca tutte le categorie presenti nel database.
	 * 
	 * @return l'insieme delle categorie trovate.
	 */
	public Set<CategoriaDTO> findAll(){
		Iterable<Categoria> categorie = catDao.findAll();
		Set<CategoriaDTO> listaCategorie = null;
		if (categorie != null) {
			listaCategorie = new HashSet<>();
			for (Categoria c : categorie) {
				// trasforma l'entity in DTO
				CategoriaDTO catDTO = new CategoriaDTO();
				catDTO.setCategoria(c.getCategoria());
				listaCategorie.add(catDTO);
			}
		}
		return listaCategorie;
	}
}
