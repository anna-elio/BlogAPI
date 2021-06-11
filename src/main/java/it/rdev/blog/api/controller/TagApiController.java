/**
 * 
 */
package it.rdev.blog.api.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.rdev.blog.api.controller.dto.TagDTO;
import it.rdev.blog.api.dao.entity.Tag;
import it.rdev.blog.api.service.impl.BlogTagDetailService;

/**
 * @author Anna Eliotropio
 *
 */
@Controller
public class TagApiController {

	@Autowired
	private BlogTagDetailService tagDetailService;

	@RequestMapping(value = "/api/tag", method = RequestMethod.GET)
	public ResponseEntity<?> getAllTag(){
		
		Set<TagDTO> tags = tagDetailService.findAll();
		
		if(tags!=null && tags.size()!=0) {
			return ResponseEntity.ok(HttpStatus.OK);
		}
		
		return ResponseEntity.ok(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/api/tag", method = RequestMethod.POST)
	public ResponseEntity<?> saveTag(@RequestBody TagDTO tag){
		return ResponseEntity.ok(tagDetailService.save(tag));
	}

}
