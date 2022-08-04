package com.thiagosena.exercise2.domain.services.impl;

import com.thiagosena.exercise2.application.web.payloads.response.CountryDto;
import com.thiagosena.exercise2.application.web.payloads.response.CountryTotalDto;
import com.thiagosena.exercise2.domain.services.CountryService;
import com.thiagosena.exercise2.resources.gateways.CountryGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

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
    public List<CountryDto> getCountriesSpeakLanguage(String language) {
        List<CountryDto> countries = countryGateway.getCountries();
        if (countries.isEmpty()) {
            log.debug("There are no registered countries");
            return null;
        } else {
            return countries.stream()
                    .filter(country -> country.languages().contains(language))
                    .toList();
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
                    .toList().size());
        }
        return total;
    }
}
