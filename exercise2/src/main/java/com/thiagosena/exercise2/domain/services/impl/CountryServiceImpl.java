package com.thiagosena.exercise2.domain.services.impl;

import com.thiagosena.exercise2.application.exceptions.CountryNotFoundException;
import com.thiagosena.exercise2.application.web.payloads.response.CountryDto;
import com.thiagosena.exercise2.application.web.payloads.response.CountryTotalDto;
import com.thiagosena.exercise2.domain.services.CountryService;
import com.thiagosena.exercise2.resources.gateways.CountryGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {
    private final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);

    private final CountryGateway countryGateway;

    public CountryServiceImpl(CountryGateway countryGateway) {
        this.countryGateway = countryGateway;
    }

    private void verifyCountries(List<CountryDto> countries) {
        if (countries == null || countries.isEmpty()) {
            log.error("There are no registered countries");
            throw new CountryNotFoundException("There are no registered countries");
        }
    }

    @Override
    public CountryTotalDto getTotalCountriesWorld() {
        List<CountryDto> countries = countryGateway.getCountries();
        verifyCountries(countries);
        return new CountryTotalDto(countries.size());
    }

    @Override
    public CountryDto getCountryMostLanguagesAndSpeakGerman(String language) {
        List<CountryDto> countries = countryGateway.getCountries();
        verifyCountries(countries);
        return countries.stream()
                .filter(country -> country.languages().contains(language))
                .max(Comparator.comparing(countryDto -> countryDto.languages()
                        .size())).orElseThrow(() ->
                        new CountryNotFoundException("Not exists country with language=" + language));
    }

    @Override
    public CountryTotalDto getTotalLanguagesWorld() {
        List<CountryDto> countries = countryGateway.getCountries();
        verifyCountries(countries);
        return new CountryTotalDto(
                countries.stream()
                        .map(CountryDto::languages)
                        .flatMap(Collection::stream)
                        .distinct()
                        .toList().size()
        );
    }

    @Override
    public CountryDto getCountryWithMoreLanguages() {
        List<CountryDto> countries = countryGateway.getCountries();
        verifyCountries(countries);
        return countries.stream()
                .max(Comparator.comparing(countryDto -> countryDto.languages().size()))
                .orElse(null);
    }

    @Override
    public Map<String, Long> getMostCommonLanguagesAllCountries() {
        List<CountryDto> countries = countryGateway.getCountries();
        verifyCountries(countries);
        return countries.stream()
                .map(CountryDto::languages)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(lang -> lang, Collectors.counting()))
                .entrySet().stream()
                .filter(m -> m.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
