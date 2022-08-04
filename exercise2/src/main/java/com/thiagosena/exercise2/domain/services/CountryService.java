package com.thiagosena.exercise2.domain.services;

import com.thiagosena.exercise2.application.web.payloads.response.CountryDto;
import com.thiagosena.exercise2.application.web.payloads.response.CountryTotalDto;

import java.util.Map;

public interface CountryService {
    CountryTotalDto getTotalCountriesWorld();

    CountryDto getCountryMostLanguagesAndSpeakGerman(String language);

    CountryTotalDto getTotalLanguagesWorld();

    CountryDto getCountryWithMoreLanguages();

    Map<String, Long> getMostCommonLanguagesAllCountries();
}
