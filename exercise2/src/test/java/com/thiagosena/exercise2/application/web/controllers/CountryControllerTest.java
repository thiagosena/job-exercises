package com.thiagosena.exercise2.application.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thiagosena.exercise2.application.web.payloads.response.CountryDto;
import com.thiagosena.exercise2.application.web.payloads.response.CountryTotalDto;
import com.thiagosena.exercise2.domain.services.CountryService;
import com.thiagosena.exercise2.factory.CountryFactory;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CountryControllerTest {

    @Autowired
    private MockMvc mvc;

    private final CountryService service = mock(CountryService.class);

    private ClientAndServer gatewayServer;

    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    public void start() {
        gatewayServer = ClientAndServer.startClientAndServer(4400);
    }

    @BeforeEach
    public void reset() {
        gatewayServer.reset();
    }

    @AfterAll
    public void stop() {
        gatewayServer.stop();
    }

    @Test
    void shouldReturnTotalCountries() throws Exception {
        CountryTotalDto totalDto = new CountryTotalDto(3);
        when(service.getTotalCountriesWorld()).thenReturn(totalDto);

        mockCountryGateway();

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/countries/total")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.total", Matchers.is(3)));
    }

    @Test
    void shouldReturnCountryMostLanguagesAndSpeakGerman() throws Exception {
        CountryDto countryDto = new CountryDto("BE", List.of("nl", "fr", "de"));
        when(service.getCountryMostLanguagesAndSpeakGerman("de")).thenReturn(countryDto);

        mockCountryGateway();

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/countries/most-language-where-speak/{language}", "de")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.country", Matchers.is("BE")));
    }

    @Test
    void shouldReturnTotalLanguagesWorld() throws Exception {
        CountryTotalDto totalDto = new CountryTotalDto(5);
        when(service.getTotalLanguagesWorld()).thenReturn(totalDto);

        mockCountryGateway();

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/countries/total-languages")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.total", Matchers.is(5)));
    }

    @Test
    void shouldReturnCountryWithMoreLanguages() throws Exception {
        CountryDto countryDto = new CountryDto("BE", List.of("nl", "fr", "de"));
        when(service.getCountryWithMoreLanguages()).thenReturn(countryDto);

        mockCountryGateway();

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/countries/more-languages")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.country", Matchers.is("BE")));
    }

    @Test
    void shouldReturnMostCommonLanguagesAllCountries() throws Exception {
        Map<String, Long> map = Map.of("nl", 2L);
        when(service.getMostCommonLanguagesAllCountries()).thenReturn(map);

        mockCountryGateway();

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/countries/common-languages")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nl", Matchers.is(2)));
    }

    private void mockCountryGateway() throws JsonProcessingException {
        String countriesJson = mapper.writeValueAsString(CountryFactory.getCountries());
        gatewayServer
                .when(HttpRequest
                        .request()
                        .withMethod("GET"))
                .respond(HttpResponse
                        .response()
                        .withContentType(org.mockserver.model.MediaType.APPLICATION_JSON)
                        .withStatusCode(HttpStatus.OK.value())
                        .withBody(countriesJson));
    }
}
