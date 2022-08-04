package com.thiagosena.exercise2.factory;

import com.thiagosena.exercise2.application.web.payloads.response.CountryDto;

import java.util.List;

public class CountryFactory {
    public static List<CountryDto> getCountries() {
        return List.of(
                new CountryDto("BE", List.of("nl", "fr", "de")),
                new CountryDto("PT", List.of("pt")),
                new CountryDto("US", List.of("en"))
        );
    }
}
