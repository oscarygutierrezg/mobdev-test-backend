package cl.com.mobdev.testbackend.service;

import cl.com.mobdev.testbackend.dto.CharacterDto;

/**
 * The Interface ISearchService.
 */
public interface SearchService {

	/**
	 * Search.
	 *
	 * @param id the id
	 * @return the character dto
	 */
	public CharacterDto search(int id);
}
