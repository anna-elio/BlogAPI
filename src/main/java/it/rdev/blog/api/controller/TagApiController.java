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
 * Controller classe Tag.
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
	 * @return Status Code 200 se sono stati restituiti i tag.<br>
	 *         Status Code 404 se non e' presente alcun tag all’interno del
	 *         database.
	 */
	@RequestMapping(value = "/api/tag", method = RequestMethod.GET)
	public ResponseEntity<?> getAllTag() {

		Set<TagDTO> tags = tagDetailService.findAll();

		if (tags != null && tags.size() != 0) {
			return ResponseEntity.ok(HttpStatus.OK);
		}

		return ResponseEntity.ok(HttpStatus.NOT_FOUND);
	}

	// @RequestMapping(value = "/api/tag", method = RequestMethod.POST)
	// public ResponseEntity<?> saveTag(@RequestBody TagDTO tag) {
	// return ResponseEntity.ok(tagDetailService.save(tag));
	// }

}
