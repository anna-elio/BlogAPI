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

import it.rdev.blog.api.controller.dto.CategoriaDTO;
import it.rdev.blog.api.service.impl.BlogCategoriaDetailService;

/**
 * Controller classe categoria.
 * 
 * @author Anna Eliotropio
 *
 */
@RestController
public class CategoriaApiController {

	@Autowired
	private BlogCategoriaDetailService catDetailService;

	/**
	 * Restituisce tutte le categorie presenti nel database.
	 * 
	 * @return Status Code 200 se sono stati restituite le categorie.<br>
	 *         Status Code 404 se non e' presente alcuna categorias all’interno del
	 *         database.
	 */
	@RequestMapping(value = "/api/categoria", method = RequestMethod.GET)
	public ResponseEntity<?> getAllCat() {
		Set<CategoriaDTO> categorie = catDetailService.findAll();
		if (categorie != null && !categorie.isEmpty()) {
			return ResponseEntity.ok(HttpStatus.OK);
		}

		return ResponseEntity.ok(HttpStatus.NOT_FOUND);
	}

}
