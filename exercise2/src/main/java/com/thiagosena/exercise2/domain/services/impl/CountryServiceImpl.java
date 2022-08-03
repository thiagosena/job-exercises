package com.thiagosena.exercise2.domain.services.impl;

import com.thiagosena.exercise2.application.web.payloads.response.CountryDto;
import com.thiagosena.exercise2.domain.services.CountryService;
import com.thiagosena.exercise2.resources.gateways.CountryGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);
    @Resource
    private CountryGateway countryGateway;

    @Override
    public Integer getTotalCountriesWorld() {
        log.debug("Get countries from countryGateway");
        List<CountryDto> countries = countryGateway.getCountries();
        if (countries.isEmpty()) {
            log.debug("There are no registered countries");
            return 0;
        } else {
            return countries.size();
        }
    }
}
