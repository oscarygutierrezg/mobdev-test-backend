package cl.com.mobdev.testbackend.service.impl;

import cl.com.mobdev.testbackend.dto.CharacterDto;
import cl.com.mobdev.testbackend.dto.CharacterMapper;
import cl.com.mobdev.testbackend.dto.OriginMapper;
import cl.com.mobdev.testbackend.model.Character;
import cl.com.mobdev.testbackend.model.Location;
import cl.com.mobdev.testbackend.service.SearchService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Value("${ms.rickandmortyapi.url}")
    private String rickAndMortyApiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CharacterMapper characterMapper;

    @Autowired
    private OriginMapper originMapper;

    @Override
    public CharacterDto search(int id) {

        Map<String, Integer> parameters = new HashMap<>();
        parameters.put("id", id);
        ResponseEntity<Character> responseCharacter = restTemplate
                .exchange(rickAndMortyApiUrl, HttpMethod.GET,
                        new HttpEntity<>(new HttpHeaders())
                        , Character.class, parameters);
        Character character = responseCharacter.getBody();
        CharacterDto characterDto = characterMapper.toDto(character);
        characterDto.setOrigin(originMapper.toDto(null));
        if (character != null && character.getOrigin() != null && character.getOrigin().getUrl() != null && !character.getOrigin().getUrl().isEmpty()) {
            ResponseEntity<Location> responseLocation = restTemplate
                    .getForEntity(character.getOrigin().getUrl(), Location.class);
            Location location = responseLocation.getBody();
            characterDto.setOrigin(originMapper.toDto(location));
        }
        return characterDto;
    }

}
