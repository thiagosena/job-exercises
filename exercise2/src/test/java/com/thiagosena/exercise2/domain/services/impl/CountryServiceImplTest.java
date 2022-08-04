package com.thiagosena.exercise2.domain.services.impl;

import com.thiagosena.exercise2.application.web.payloads.response.CountryDto;
import com.thiagosena.exercise2.application.web.payloads.response.CountryTotalDto;
import com.thiagosena.exercise2.domain.services.CountryService;
import com.thiagosena.exercise2.factory.CountryFactory;
import com.thiagosena.exercise2.resources.gateways.CountryGateway;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountryServiceImplTest {

    private final CountryGateway gateway = mock(CountryGateway.class);
    private final CountryService service = new CountryServiceImpl(gateway);

    @Test
    void shouldReturnTotalCountriesWorld() {
        when(gateway.getCountries()).thenReturn(CountryFactory.getCountries());
        CountryTotalDto totalCountriesWorld = service.getTotalCountriesWorld();
        assertEquals(3, totalCountriesWorld.getTotal());
    }

    @Test
    void shouldReturnCountriesSpeakLanguage() {
        when(gateway.getCountries()).thenReturn(CountryFactory.getCountries());
        List<CountryDto> enLanguage = service.getCountriesSpeakLanguage("en");
        assertFalse(enLanguage.isEmpty());
        assertEquals(1, enLanguage.size());
        assertEquals("US", enLanguage.get(0).country());
    }

    @Test
    void shouldReturnTotalLanguagesWorld() {
        when(gateway.getCountries()).thenReturn(CountryFactory.getCountries());
        CountryTotalDto totalLanguagesWorld = service.getTotalLanguagesWorld();
        assertEquals(5, totalLanguagesWorld.getTotal());
    }
}
