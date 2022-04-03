package cl.com.mobdev.testbackend.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class RickAndMortyApiMock extends WireMockServer {

    public RickAndMortyApiMock(int port) {
        super(port);
    }


    public void startMockServer() {
        start();
        stubFor(
                WireMock.get(WireMock.urlPathMatching("/api/character/1"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.OK.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                        .withBodyFile("mock/character.json"))
        );

        stubFor(
                WireMock.get(WireMock.urlPathMatching("/api/character/2"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.NOT_FOUND.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                        .withBodyFile("mock/character-not-found.json"))
        );
        stubFor(
                WireMock.get(WireMock.urlPathMatching("/api/character/3"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                        .withBodyFile("mock/character-500.json"))
        );
        stubFor(
                WireMock.get(WireMock.urlPathMatching("/api/location/3"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.OK.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                        .withBodyFile("mock/location.json"))
        );

        stubFor(
                WireMock.get(WireMock.urlPathMatching("/api/character/4"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.OK.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                        .withBodyFile("mock/character4.json"))
        );

        stubFor(
                WireMock.get(WireMock.urlPathMatching("/api/character/5"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.OK.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                        .withBodyFile("mock/character5.json"))
        );

        stubFor(
                WireMock.get(WireMock.urlPathMatching("/api/character/6"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.OK.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                        .withBodyFile("mock/character6.json"))
        );

    }
}
