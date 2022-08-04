package com.thiagosena.exercise2.domain.services.impl;

import com.thiagosena.exercise2.application.exceptions.CountryNotFoundException;
import com.thiagosena.exercise2.application.web.payloads.response.CountryDto;
import com.thiagosena.exercise2.application.web.payloads.response.CountryTotalDto;
import com.thiagosena.exercise2.domain.services.CountryService;
import com.thiagosena.exercise2.factory.CountryFactory;
import com.thiagosena.exercise2.resources.gateways.CountryGateway;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountryServiceImplTest {

    private final CountryGateway gateway = mock(CountryGateway.class);
    private final CountryService service = new CountryServiceImpl(gateway);

    @Test
    void shouldReturnTotalCountriesWorld() {
        when(gateway.getCountries()).thenReturn(CountryFactory.getCountries());
        CountryTotalDto totalCountriesWorld = service.getTotalCountriesWorld();
        assertEquals(3, totalCountriesWorld.total());
    }

    @Test
    void shouldReturnCountryWithMostLanguageWhereTheySpeak() {
        when(gateway.getCountries()).thenReturn(CountryFactory.getCountries());
        CountryDto enLanguage = service.getCountryMostLanguagesAndSpeakGerman("en");
        assertEquals("US", enLanguage.country());
        assertTrue(enLanguage.languages().contains("en"));
    }

    @Test
    void shouldReturnTotalLanguagesWorld() {
        when(gateway.getCountries()).thenReturn(CountryFactory.getCountries());
        CountryTotalDto totalLanguagesWorld = service.getTotalLanguagesWorld();
        assertEquals(5, totalLanguagesWorld.total());
    }

    @Test
    void shouldReturnCountryWithMoreLanguages() {
        when(gateway.getCountries()).thenReturn(CountryFactory.getCountries());
        CountryDto country = service.getCountryWithMoreLanguages();
        assertEquals(3, country.languages().size());
    }

    @Test
    void shouldReturnMostCommonLanguagesAllCountries() {
        when(gateway.getCountries()).thenReturn(CountryFactory.getCountries());
        Map<String, Long> language = service.getMostCommonLanguagesAllCountries();
        assertEquals(2, language.get("nl"));
        assertNotEquals(1, language.get("en"));
    }

    @Test
    void shouldThrowCountryNotFountExceptionWhenNotRegisteredCountry() {
        when(gateway.getCountries()).thenReturn(null);
        assertThrows(CountryNotFoundException.class, service::getTotalCountriesWorld);
    }

    @Test
    void shouldThrowCountryNotFountExceptionWhenEmptyCountryList() {
        when(gateway.getCountries()).thenReturn(Collections.emptyList());
        assertThrows(CountryNotFoundException.class, service::getTotalCountriesWorld);
    }

    @Test
    void shouldThrowCountryNotFountExceptionWhenCountryMostLanguagesAndSpeakGerman() {
        when(gateway.getCountries()).thenReturn(CountryFactory.getCountries());
        assertThrows(CountryNotFoundException.class, () -> service.getCountryMostLanguagesAndSpeakGerman("kk"));
    }
}
