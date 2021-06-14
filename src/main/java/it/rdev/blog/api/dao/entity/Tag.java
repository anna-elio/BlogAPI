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
 * Classe che modella l'entità tag.
 * 
 * @author Anna Eliotropio
 *
 */

@Entity
@Table(name = "tags")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private long id;
	
	@Column
	private String tag;
	
	@ManyToMany(
			mappedBy = "tags", 
			fetch = FetchType.EAGER, 
			cascade = CascadeType.PERSIST)
	
	@JsonIgnore
	private Set<Articolo> articoli = new HashSet<>(); //hash set perche' non mi serve l'ordine
	
	/**
	 * Restituisce l'ID del tag.
	 * 
	 * @return long id che identifica il tag.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Setta l'ID del tag.
	 * 
	 * @param id l'ID da settare.
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Restituisce il nome del tag.
	 * 
	 * @return String che rappresenta il tag.
	 */
	public String getTag() {
		return tag;
	}
	
	/**
	 * Setta il nome del tag.
	 * 
	 * @param tag il tag da settare.
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	/**
	 * Restituisce l'insieme di articoli associati al tag.
	 * 
	 * @return l'insieme di articoli associati al tag.
	 */
	public Set<Articolo> getArticoli() {
		return articoli;
	}
	
	/**
	 * Setta l'insieme di articoli associati al tag.
	 * 
	 * @param articoli l'insieme di articoli da settare.
	 */
	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}


}
