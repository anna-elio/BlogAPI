/**
 * 
 */
package it.rdev.blog.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.rdev.blog.api.config.JwtTokenUtil;
import it.rdev.blog.api.controller.dto.ArticoloDTO;
import it.rdev.blog.api.dao.entity.Articolo;
import it.rdev.blog.api.service.impl.BlogArticoloDetailService;

/**
 * @author Anna Eliotropio
 *
 */
@RestController
public class ArticoloController {

	@Autowired
	private JwtTokenUtil jwtUtil;

	@Autowired
	private BlogArticoloDetailService articoloDetailService;

	/**
	 * Restituisce un singolo articolo in formato JSON identificato dall'ID passato
	 * nella path variable.
	 * 
	 * L'endpoint e' raggiungibile da tutti gli utenti (registrati e anonimi), se
	 * l'ID è relativo ad un articolo in stato bozza sara' restituito solo
	 * all'autore, gli altri utenti otterranno uno status code 404.
	 * 
	 * @param id    il codice identificativo dell'articolo.
	 * @param token il token di autenticazione.
	 * @return <b>Status Code 200</b> se l’id passato come parametro e' relativo ad
	 *         un articolo in stato pubblicato o ad un articolo in stato bozza e
	 *         l’utente che lo richiede ne e' l’autore.<br>
	 *         <b>Status Code 404</b> se l’id passato non corrisponde a nessun
	 *         articolo o se l’articolo che identifica e' in stato bozza ma l’utente
	 *         loggato non ne e' l’autore oppure e' un utente anonimo.
	 */
	@RequestMapping(value = "/api/articolo/{id:\\d+}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id,
			@RequestHeader(required = false, name = "Authorization") String token) {
		// Trovo l'articolo
		final Articolo articolo = articoloDetailService.findById(id);
		// Controllo lo stato
		if (articolo.getStato().equals("pubblicato")) {
			return new ResponseEntity<>(articolo, HttpStatus.OK);
		} else {
			// Controllo l'autorizzazione
			if (token != null && token.startsWith("Bearer")) {
				token = token.replaceAll("Bearer ", "");
				long idUser = jwtUtil.getUserIdFromToken(token);
				// Controllo che l'id dell'utente loggato sia lo stesso dell'autore
				if (articolo.getAutore().getId() == idUser) {
					return new ResponseEntity<>(articolo, HttpStatus.OK);
				}
			}
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Il servizio permetterà l’inserimento di un articolo ad un giornalista
	 * registrato. Dovra' prendere in input un articolo in formato JSON compilato in
	 * ogni sua parte ed indicare all’utente l’avvenuto inserimento senza restituire
	 * alcun valore in response. L’articolo inserito e' sempre in bozza, il
	 * passaggio in stato pubblicato sara' effettuato da un altro servizio.
	 * 
	 * @param articolo l'articolo, compilato in ogni sua parte, da inserire.
	 * @param token    il token di autenticazione.
	 * @return <b>Status Code 204</b> se l'articolo e' stato correttamente
	 *         inserito.<br>
	 *         <b>Status Code 400</b> se uno dei parametri passati in input non è
	 *         valorizzato o corretto.<br>
	 *         <b>Status Code 401</b> se un utente non loggato prova ad effettuare
	 *         l'inserimento di un articolo.
	 */
	@RequestMapping(value = "/api/articolo", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody ArticoloDTO articolo,
			@RequestHeader(name = "Authorization") String token) {
		
		//controllo l'autorizzazione
		if (token != null && token.startsWith("Bearer")) {
			token = token.replaceAll("Bearer ", "");
			long idUser = jwtUtil.getUserIdFromToken(token);
			//controllo se l'articolo e' stato salvato correttamente
			if (articoloDetailService.save(articolo, idUser)) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
}
