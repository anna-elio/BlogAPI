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
import it.rdev.blog.api.service.CategoriaDetailService;

/**
 * @author Anna Eliotropio
 *
 */
@Service
public class BlogCategoriaDetailService implements CategoriaDetailService {

	@Autowired
	private CategoriaDao catDao;

	/**
	 * @inheritDoc
	 */
	@Override
	public Set<CategoriaDTO> findAll() {
		Iterable<Categoria> categorie = catDao.findAll();
		Set<CategoriaDTO> listaCategorie = null;
		if (categorie != null) {
			listaCategorie = new HashSet<>();
			for (Categoria c : categorie) {
				listaCategorie.add(toDto(c));
			}
		}
		return listaCategorie;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public Categoria save(CategoriaDTO categoria) {
		Categoria newCat = new Categoria();
		newCat.setCategoria(categoria.getCategoria());
		return catDao.save(newCat);
	}

	/**
	 * Trasforma l'entity {@link Categoria} in DTO.
	 * 
	 * @param c l'entita' da trasformare.
	 * @return il DTO dell'entita'.
	 */
	private CategoriaDTO toDto(Categoria c) {
		CategoriaDTO catDTO = new CategoriaDTO();
		catDTO.setCategoria(c.getCategoria());
		return catDTO;
	}

	@Override
	public Categoria findByName(String categoria) {
		Categoria cat = catDao.findByCategoria(categoria);
		return cat;
	}
}
