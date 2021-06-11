/**
 * 
 */
package it.rdev.blog.api.dao;

import org.springframework.data.repository.CrudRepository;

import it.rdev.blog.api.dao.entity.Tag;

/**
 * @author Anna Eliotropio
 *
 */
public interface TagDao extends CrudRepository<Tag, Integer>{

	Tag findByTag(String tag);
}
