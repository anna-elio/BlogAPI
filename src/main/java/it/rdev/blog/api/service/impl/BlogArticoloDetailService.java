/**
 * 
 */
package it.rdev.blog.api.service.impl;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rdev.blog.api.controller.dto.ArticoloDTO;
import it.rdev.blog.api.controller.dto.CategoriaDTO;
import it.rdev.blog.api.controller.dto.TagDTO;
import it.rdev.blog.api.dao.ArticoloDao;
import it.rdev.blog.api.dao.CategoriaDao;
import it.rdev.blog.api.dao.TagDao;
import it.rdev.blog.api.dao.UserDao;
import it.rdev.blog.api.dao.entity.Articolo;
import it.rdev.blog.api.dao.entity.Categoria;
import it.rdev.blog.api.dao.entity.Tag;
import it.rdev.blog.api.service.ArticoloDetailService;

/**
 * @author Anna Eliotropio
 *
 */
@Service
public class BlogArticoloDetailService implements ArticoloDetailService {

	Logger logger = LoggerFactory.getLogger(BlogArticoloDetailService.class);

	@Autowired
	private ArticoloDao articoloDao;

	@Autowired
	private CategoriaDao categoriaDao;

	@Autowired
	private TagDao tagDao;

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
		logger.info("getArticoloById(" + id + ") called. Retrieving informations.");

		Articolo articolo = null;
		if (articoloDao.findById(id).isPresent()) {
			articolo = articoloDao.findById(id).get();
		}
		return articolo;
	}

	/**
	 * 
	 * @inheritDoc
	 */
	@Override
	public boolean save(ArticoloDTO articolo, Long idUser) {
		logger.info("save " + articolo.getTitolo() + " from user " + idUser + ". Retrieving informations.");
		Articolo newArticolo = new Articolo();
		newArticolo.setAutore(userDao.findById(idUser).get());
		newArticolo.setTitolo(articolo.getTitolo());
		newArticolo.setSottotitolo(articolo.getSottotitolo());
		newArticolo.setTesto(articolo.getTesto());

		CategoriaDTO cat = articolo.getCategoria();
		Categoria categoria = categoriaDao.findByCategoria(cat.getCategoria());
		newArticolo.setCategoria(categoria);

		// TODO capire perchè non salva i tag
		Set<Tag> tags = new HashSet<>();
		for (TagDTO t : articolo.getTags()) {
			tags.add(tagDao.findByTag(t.getTag()));
		}
		newArticolo.setTags(tags);

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
