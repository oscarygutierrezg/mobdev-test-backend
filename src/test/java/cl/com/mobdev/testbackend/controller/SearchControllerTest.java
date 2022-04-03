package cl.com.mobdev.testbackend.controller;

import cl.com.mobdev.testbackend.TestBackendApplication;
import cl.com.mobdev.testbackend.config.RickAndMortyApiMock;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@ContextConfiguration(classes = TestBackendApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SearchControllerTest {

    private RickAndMortyApiMock rickAndMortyApiMock = new RickAndMortyApiMock(9090);


    @BeforeAll
    void init() {
        rickAndMortyApiMock.startMockServer();
    }

    @AfterAll
    void shutDown() {
        rickAndMortyApiMock.stop();
    }


    private MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;


    @BeforeEach
    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void search() throws Exception {
        mvc
                .perform(MockMvcRequestBuilders.get("/v1/search/character/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(
                        ResultMatcher.matchAll(
                                MockMvcResultMatchers.status().isOk(),
                                MockMvcResultMatchers.jsonPath("$.name", Matchers.equalTo("Rick Sanchez")),
                                MockMvcResultMatchers.jsonPath("$.status", Matchers.equalTo("Alive")),
                                MockMvcResultMatchers.jsonPath("$.species", Matchers.equalTo("Human"))
                        )
                );
    }

    @Test
    public void searchError() throws Exception {
        mvc
                .perform(MockMvcRequestBuilders.get("/v1/search/character/2")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(
                        ResultMatcher.matchAll(
                                MockMvcResultMatchers.status().isNotFound(),
                                MockMvcResultMatchers.jsonPath("$.error", Matchers.equalTo("Character not found"))
                        )
                );
    }

    @Test
    public void searchError500() throws Exception {
        mvc
                .perform(MockMvcRequestBuilders.get("/v1/search/character/3")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print());
    }


}
