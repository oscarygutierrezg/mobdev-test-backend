package cl.com.mobdev.testbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.com.mobdev.testbackend.dto.CharacterDto;
import cl.com.mobdev.testbackend.service.SearchService;


/**
 * The Class SearchController.
 * 
 * API de busqueda en Rick and Morty API
 */
@RestController
@RequestMapping("/v1/search")
public class SearchController {

	/** The search service. */
	@Autowired
	private SearchService searchService;


	/**
	 * Search.
	 * 
	 * Método encargado de la búsquda desde la api de  Rick and Morty
	 * 
	 *
	 * @param id the id character
	 * @return the response entity
	 */
	@GetMapping(value = "/character/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CharacterDto>  search(@PathVariable("id") int id) {
		System.out.println("Error ");
		return ResponseEntity.status(HttpStatus.OK).body(searchService.search(id));
	}
}
