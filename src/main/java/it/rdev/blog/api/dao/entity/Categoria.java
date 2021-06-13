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
 * Classe che modella l'entità categoria.
 * 
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
	private Set<Articolo> articoli= new HashSet<>(); //hash set perche' non mi serve l'ordine
	
	/**
	 * Restituisce l'ID della categoria.
	 * 
	 * @return long id che identifica la categoria.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Setta l'ID della categoria.
	 * 
	 * @param id l'ID da settare.
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Restituisce il nome della categoria.
	 * 
	 * @return String che rappresenta la categoria.
	 */
	public String getCategoria() {
		return categoria;
	}
	
	/**
	 * Setta il nome della categoria.
	 * 
	 * @param categoria la categoria da settare.
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * Restituisce l'insieme degli articoli appartenenti alla categoria.
	 * 
	 * @return l'insieme degli articoli della categoria.
	 */
	public Set<Articolo> getArticoli() {
		return articoli;
	}
	
	/**
	 * Setta l'insieme degli aricoli appartenenti alla categoria.
	 * 
	 * @param articoli l'insieme di articoli da settare.
	 */
	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}

}
