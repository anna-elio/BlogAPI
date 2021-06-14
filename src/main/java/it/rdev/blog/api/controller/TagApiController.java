/**
 * 
 */
package it.rdev.blog.api.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.rdev.blog.api.controller.dto.TagDTO;
import it.rdev.blog.api.service.impl.BlogTagDetailService;

/**
 * Controller classe Tag.<br>
 * Contiene gli endpoint dei tag:
 * 
 * {@code path:/api/tag}.
 * 
 * 
 * @author Anna Eliotropio
 *
 */
@RestController
public class TagApiController {

	@Autowired
	private BlogTagDetailService tagDetailService;

	/**
	 * Restituisce tutti i tag presenti nel database.
	 * 
	 * @return <b>Status Code 200</b> se sono stati restituiti i tag.<br>
	 *         <b>Status Code 404</b> se non e' presente alcun tag all’interno del
	 *         database.
	 */
	@RequestMapping(value = "/api/tag", method = RequestMethod.GET)
	public ResponseEntity<?> getAllTag() {

		Set<TagDTO> tags = tagDetailService.findAll();

		if (tags != null && tags.size() != 0) {
			return new ResponseEntity<>(tags, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
