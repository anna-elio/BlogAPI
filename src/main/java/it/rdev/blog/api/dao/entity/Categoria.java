/**
 * 
 */
package it.rdev.blog.api.dao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Anna Eliotropio
 *
 */
@Entity
@Table(name = "categorie")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String categoria;
	@OneToMany(mappedBy = "categoria")
	@JsonIgnore
	private Set<Articolo> articoli= new HashSet<>();
	
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
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
