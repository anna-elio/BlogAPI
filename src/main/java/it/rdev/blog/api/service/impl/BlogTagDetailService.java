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

/**
 * @author Anna Eliotropio
 *
 */
@Service
public class BlogTagDetailService {

	@Autowired
	private TagDao tagDao;
	
	public Set<TagDTO> findAll(){
		Iterable<Tag> tags=tagDao.findAll();
		Set<TagDTO> listaTags = null;
		if (tags!=null) {
			listaTags = new HashSet<>();
			for (Tag t : tags) {
				//trasforma l'entity in DTO
				TagDTO tagDTO = new TagDTO();
				tagDTO.setTag(t.getTag());
				listaTags.add(tagDTO);
			} 
		}
		return listaTags;
	}
	
	public Tag save(TagDTO tag) {
		Tag newTag = new Tag();
		newTag.setTag(tag.getTag());
		return newTag;
		
	}
	
}
