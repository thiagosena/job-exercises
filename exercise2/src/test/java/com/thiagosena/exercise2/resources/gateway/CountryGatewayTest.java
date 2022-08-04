package com.thiagosena.exercise2.resources.gateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thiagosena.exercise2.application.web.payloads.response.CountryDto;
import com.thiagosena.exercise2.factory.CountryFactory;
import com.thiagosena.exercise2.resources.gateways.CountryGateway;
import org.junit.jupiter.api.*;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CountryGatewayTest {

    private ClientAndServer gatewayServer;

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private CountryGateway gateway;

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
    void shouldReturnAllCountries() throws JsonProcessingException {
        String json = mapper.writeValueAsString(CountryFactory.getCountries());

        gatewayServer
                .when(HttpRequest
                        .request()
                        .withMethod("GET"))
                .respond(HttpResponse
                        .response()
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withStatusCode(HttpStatus.OK.value())
                        .withBody(json));

        List<CountryDto> countries = gateway.getCountries();
        assertEquals(3, countries.size());
    }
}
