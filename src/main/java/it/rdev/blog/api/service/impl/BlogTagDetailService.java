/**
 * 
 */
package it.rdev.blog.api.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rdev.blog.api.controller.dto.TagDTO;
import it.rdev.blog.api.dao.TagDao;
import it.rdev.blog.api.dao.entity.Tag;
import it.rdev.blog.api.service.TagDetailService;

/**
 * Servizio per il controller TagApiController.
 * 
 * @author Anna Eliotropio
 *
 */
@Service
public class BlogTagDetailService implements TagDetailService {

	@Autowired
	private TagDao tagDao;

	/**
	 * @inheritDoc
	 */
	@Override
	public Set<TagDTO> findAll() {
		Iterable<Tag> tags = tagDao.findAll();
		Set<TagDTO> listaTags = null;
		if (tags != null) {
			listaTags = new HashSet<>();
			for (Tag t : tags) {
				listaTags.add(toDto(t));
			}
		}
		return listaTags;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public Tag save(TagDTO tag) {
		Tag newTag = new Tag();
		newTag.setTag(tag.getTag());
		return tagDao.save(newTag);

	}

	/**
	 * Trasforma l'entity {@link Tag} in DTO.
	 * 
	 * @param t l'entita' da trasformare.
	 * @return il DTO dell'entita'.
	 */
	private TagDTO toDto(Tag t) {
		TagDTO tagDTO = new TagDTO();
		tagDTO.setTag(t.getTag());
		return tagDTO;
	}
}
