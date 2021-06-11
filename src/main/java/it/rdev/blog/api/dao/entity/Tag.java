/**
 * 
 */
package it.rdev.blog.api.dao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Anna Eliotropio
 *
 */

@Entity
@Table(name = "tags")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String tag;
	@ManyToMany(
			mappedBy = "tags", 
			fetch = FetchType.EAGER, 
			cascade = CascadeType.PERSIST)
	@JsonIgnore
	private Set<Articolo> articoli = new HashSet<>();
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * @return the articoli
	 */
	public Set<Articolo> getArticoli() {
		return articoli;
	}
	/**
	 * @param articoli the articoli to set
	 */
	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}


}
