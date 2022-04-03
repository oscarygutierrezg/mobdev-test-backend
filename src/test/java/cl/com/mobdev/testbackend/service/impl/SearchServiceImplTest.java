package cl.com.mobdev.testbackend.service.impl;

import cl.com.mobdev.testbackend.TestBackendApplication;
import cl.com.mobdev.testbackend.config.RickAndMortyApiMock;
import cl.com.mobdev.testbackend.dto.CharacterDto;
import cl.com.mobdev.testbackend.service.SearchService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest
@ContextConfiguration(classes = TestBackendApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SearchServiceImplTest {

    private RickAndMortyApiMock rickAndMortyApiMock = new RickAndMortyApiMock(9090);

    @Autowired
    SearchService searchService;

    @BeforeAll
    void init() {
        rickAndMortyApiMock.startMockServer();
    }

    @AfterAll
    void shutDown() {
        rickAndMortyApiMock.stop();
    }

    @Test
    public void searchOriginNull() throws Exception {
        CharacterDto characterDto = searchService.search(4);
        Assertions.assertTrue(characterDto.getOrigin() == null);
    }

    @Test
    public void searchOriginNull1() throws Exception {
        CharacterDto characterDto = searchService.search(5);
        Assertions.assertTrue(characterDto.getOrigin() == null);
    }

    @Test
    public void searchOriginNull2() throws Exception {
        CharacterDto characterDto = searchService.search(6);
        Assertions.assertTrue(characterDto.getOrigin() == null);
    }

}
