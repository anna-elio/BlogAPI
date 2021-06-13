/**
 * 
 */
package it.rdev.blog.api.controller.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import it.rdev.blog.api.dao.entity.Categoria;
import it.rdev.blog.api.dao.entity.Tag;
import it.rdev.blog.api.dao.entity.User;

/**
 * Articolo Transfer Object.
 * 
 * @author Anna Eliotropio
 *
 */
public class ArticoloDTO {

	private String titolo;
	private String sottotitolo;
	private String testo;
	private Categoria categoria;
	private User autore;
	private Set<Tag> tags = new HashSet<>();
	private String stato;
	private LocalDate data_pubb;
	private LocalDate data_modifica;
	private LocalDate data_creazione;

	/**
	 * Restituisce il titolo dell'articolo.
	 * 
	 * @return String che rappresenta il titolo dell'articolo.
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * Setta il titolo dell'articolo.
	 * 
	 * @param titolo il titolo da settare.
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * Restituisce il sottotitolo dell'articolo.
	 * 
	 * @return String che rappresenta il sottotitolo dell'articolo.
	 */
	public String getSottotitolo() {
		return sottotitolo;
	}

	/**
	 * Setta il sottotitolo dell'articolo.
	 * 
	 * @param sottotitolo il sottotitolo da settare.
	 */
	public void setSottotitolo(String sottotitolo) {
		this.sottotitolo = sottotitolo;
	}

	/**
	 * Restituisce il testo dell'articolo.
	 * 
	 * @return String che rappresnta il testo dell'articolo.
	 */
	public String getTesto() {
		return testo;
	}

	/**
	 * Setta il testo dell'articolo.
	 * 
	 * @param testo il testo da settare.
	 */
	public void setTesto(String testo) {
		this.testo = testo;
	}

	/**
	 * Restituisce la categoria dell'articolo.
	 * 
	 * @return Categoria oggetto che rappresenta la categoria.
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Setta la categoria dell'articolo.
	 * 
	 * @param categoria la categoria da settare
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * Restituisce l'autore dell'articolo.
	 * 
	 * @return User oggetto che rappresenta l'autore.
	 */
	public User getAutore() {
		return autore;
	}

	/**
	 * Setta l'autore dell'articolo.
	 * 
	 * @param autore l'autore da settare.
	 */
	public void setAutore(User autore) {
		this.autore = autore;
	}

	/**
	 * Restituisce il set di tag associati all'articolo.
	 * 
	 * @return insieme di tag dell'articolo.
	 */
	public Set<Tag> getTags() {
		return tags;
	}

	/**
	 * Setta l'insieme di tag da associare all'articolo.
	 * 
	 * @param tags l'insieme di tag da settare.
	 */
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	/**
	 * Restituisce lo stato dell'articolo (bozza o pubblicato).
	 * 
	 * @return String che rappresenta lo stato.
	 */
	public String getStato() {
		return stato;
	}

	/**
	 * Setta lo stato dell'articolo (bozza o pubblicato).
	 * 
	 * @param stato lo stato da settare.
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	/**
	 * Restituisce la data di pubblicazione dell'articolo.
	 * 
	 * @return LocalDate che rappresenta la data di pubblicazione.
	 */
	public LocalDate getData_pubb() {
		return data_pubb;
	}

	/**
	 * Setta la data di pubblicazione dell'articolo.
	 * 
	 * @param data_pubb la data da settare.
	 */
	public void setData_pubb(LocalDate data_pubb) {
		this.data_pubb = data_pubb;
	}

	/**
	 * Restituisce la data dell'ultima modifica dell'articolo.
	 * 
	 * @return LocalDate che rappresenta la data dell'ultima modifica.
	 */
	public LocalDate getData_modifica() {
		return data_modifica;
	}

	/**
	 * Setta la data dell'ultima modifica dell'articolo.
	 * 
	 * @param data_modifica la data da settare.
	 */
	public void setData_modifica(LocalDate data_modifica) {
		this.data_modifica = data_modifica;
	}

	/**
	 * Restituisce la data di creazione.
	 * 
	 * @return LocalDate che rappresenta la data di creazione.
	 */
	public LocalDate getData_creazione() {
		return data_creazione;
	}

	/**
	 * Setta la data di creazione dell'articolo.
	 * 
	 * @param data_creazione la data da settare.
	 */
	public void setData_creazione(LocalDate data_creazione) {
		this.data_creazione = data_creazione;
	}
}
