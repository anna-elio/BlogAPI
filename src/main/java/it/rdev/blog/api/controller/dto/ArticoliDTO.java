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
 * @author Anna Eliotropio
 *
 */
public class ArticoliDTO {

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
