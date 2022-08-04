package com.thiagosena.exercise2.domain.services.impl;

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

    @Override
    public CountryTotalDto getTotalCountriesWorld() {
        List<CountryDto> countries = countryGateway.getCountries();
        CountryTotalDto total = new CountryTotalDto();
        if (countries.isEmpty()) {
            log.debug("There are no registered countries");
            total.setTotal(0);
        } else {
            total.setTotal(countries.size());
        }

        return total;
    }

    @Override
    public CountryDto getCountryMostLanguagesAndSpeakGerman(String language) {
        List<CountryDto> countries = countryGateway.getCountries();
        if (countries.isEmpty()) {
            log.debug("There are no registered countries");
            return null;
        } else {
            return countries.stream()
                    .filter(country -> country.languages().contains(language))
                    .max(Comparator.comparing(countryDto -> countryDto.languages()
                            .size())).orElse(null);
        }
    }

    @Override
    public CountryTotalDto getTotalLanguagesWorld() {
        List<CountryDto> countries = countryGateway.getCountries();
        CountryTotalDto total = new CountryTotalDto();
        if (countries.isEmpty()) {
            log.debug("There are no registered countries");
            total.setTotal(0);
        } else {
            total.setTotal(countries.stream()
                    .map(CountryDto::languages)
                    .flatMap(Collection::stream)
                    .distinct()
                    .toList().size());
        }
        return total;
    }

    @Override
    public CountryDto getCountryWithMoreLanguages() {
        List<CountryDto> countries = countryGateway.getCountries();
        if (countries.isEmpty()) {
            log.debug("There are no registered countries");
            return null;
        } else {
            return countries.stream()
                    .max(Comparator.comparing(countryDto -> countryDto.languages().size()))
                    .orElse(null);
        }
    }

    @Override
    public Map<String, Long> getMostCommonLanguagesAllCountries() {
        List<CountryDto> countries = countryGateway.getCountries();

        return countries.stream()
                .map(CountryDto::languages)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(lang -> lang, Collectors.counting()))
                .entrySet().stream()
                .filter(m -> m.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
