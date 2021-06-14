/**
 * 
 */
package it.rdev.blog.api.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rdev.blog.api.controller.dto.ArticoloDTO;
import it.rdev.blog.api.dao.ArticoloDao;
import it.rdev.blog.api.dao.UserDao;
import it.rdev.blog.api.dao.entity.Articolo;
import it.rdev.blog.api.dao.entity.Categoria;
import it.rdev.blog.api.service.ArticoloDetailService;
import it.rdev.blog.api.service.CategoriaDetailService;

/**
 * @author Anna Eliotropio
 *
 */
@Service
public class BlogArticoloDetailService implements ArticoloDetailService {

	@Autowired
	private ArticoloDao articoloDao;
	
	@Autowired
	private CategoriaDetailService categoriaService;

	@Autowired
	private UserDao userDao;

	/**
	 * @inheritDoc
	 */
	@Override
	public List<Articolo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public Articolo findById(Integer id) {
		Articolo articolo = null;
		if (articoloDao.findById(id).isPresent()) {
			articolo = articoloDao.findById(id).get();
		}
		return articolo;
	}

	/**
	 * @param idUser l'ID dell'utente che sta inserendo l'articolo nel database.
	 * @inheritDoc
	 */
	@Override
	public boolean save(ArticoloDTO articolo, Long idUser) {
		Articolo newArticolo = new Articolo();
		newArticolo.setAutore(userDao.findById(idUser).get());
		newArticolo.setTitolo(articolo.getTitolo());
		newArticolo.setSottotitolo(articolo.getSottotitolo());
		newArticolo.setTesto(articolo.getTesto());

		Categoria categoria = categoriaService.findByName(articolo.getCategoria());
		
		newArticolo.setCategoria(categoria);
//		newArticolo.setTags(null);

		newArticolo.setStato("bozza");
		if (articolo.getData_creazione() != null) {
			newArticolo.setData_creazione(articolo.getData_creazione());
		} else {
			newArticolo.setData_creazione(LocalDateTime.now());
		}
		newArticolo.setData_modifica(LocalDateTime.now());
		newArticolo.setData_pubb(null);
		articoloDao.save(newArticolo);
		return false;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public Articolo update(ArticoloDTO articolo) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public Articolo delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
