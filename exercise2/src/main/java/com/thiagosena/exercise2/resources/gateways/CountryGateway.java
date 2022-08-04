package com.thiagosena.exercise2.resources.gateways;

import com.thiagosena.exercise2.application.web.payloads.response.CountryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient(value = "feignCountries", url = "${country-service.url}")
public interface CountryGateway {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<CountryDto> getCountries();
}
