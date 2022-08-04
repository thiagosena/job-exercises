package com.thiagosena.exercise2.domain.services;

import com.thiagosena.exercise2.application.web.payloads.response.CountryDto;
import com.thiagosena.exercise2.application.web.payloads.response.CountryTotalDto;

import java.util.List;

public interface CountryService {
    CountryTotalDto getTotalCountriesWorld();

    List<CountryDto> getCountriesSpeakLanguage(String language);

    CountryTotalDto getTotalLanguagesWorld();

    CountryDto getCountryWithMoreLanguages();
}
