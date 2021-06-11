/**
 * 
 */
package it.rdev.blog.api.dao.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Anna Eliotropio
 *
 */

@Entity
@Table(name = "articoli")
public class Articolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String titolo;
	@Column
	private String sottotitolo;
	@Column(nullable = false)
	private String testo;
	@ManyToOne
	@JoinColumn(name = "categoria")
	private Categoria categoria;
	@ManyToOne
	@JoinColumn(name = "autore")
	private User autore;
	@ManyToMany
	@JoinTable(
			name = "tags_articoli",
			joinColumns = @JoinColumn(name = "id_articolo"),
			inverseJoinColumns = @JoinColumn(name = "id_tag"))
	private Set<Tag> tags = new HashSet<>();
	@Column(nullable = false)
	private String stato;
	@Column
	private LocalDate data_pubb;
	@Column
	private LocalDate data_modifica;
	@Column(nullable = false)
	private LocalDate data_creazione;
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
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}
	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	/**
	 * @return the sottotitolo
	 */
	public String getSottotitolo() {
		return sottotitolo;
	}
	/**
	 * @param sottotitolo the sottotitolo to set
	 */
	public void setSottotitolo(String sottotitolo) {
		this.sottotitolo = sottotitolo;
	}
	/**
	 * @return the testo
	 */
	public String getTesto() {
		return testo;
	}
	/**
	 * @param testo the testo to set
	 */
	public void setTesto(String testo) {
		this.testo = testo;
	}
	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	/**
	 * @return the autore
	 */
	public User getAutore() {
		return autore;
	}
	/**
	 * @param autore the autore to set
	 */
	public void setAutore(User autore) {
		this.autore = autore;
	}
	/**
	 * @return the tags
	 */
	public Set<Tag> getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	/**
	 * @return the stato
	 */
	public String getStato() {
		return stato;
	}
	/**
	 * @param stato the stato to set
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}
	/**
	 * @return the data_pubb
	 */
	public LocalDate getData_pubb() {
		return data_pubb;
	}
	/**
	 * @param data_pubb the data_pubb to set
	 */
	public void setData_pubb(LocalDate data_pubb) {
		this.data_pubb = data_pubb;
	}
	/**
	 * @return the data_modifica
	 */
	public LocalDate getData_modifica() {
		return data_modifica;
	}
	/**
	 * @param data_modifica the data_modifica to set
	 */
	public void setData_modifica(LocalDate data_modifica) {
		this.data_modifica = data_modifica;
	}
	/**
	 * @return the data_creazione
	 */
	public LocalDate getData_creazione() {
		return data_creazione;
	}
	/**
	 * @param data_creazione the data_creazione to set
	 */
	public void setData_creazione(LocalDate data_creazione) {
		this.data_creazione = data_creazione;
	}
	
}
