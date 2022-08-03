package com.thiagosena.exercise2.resources.gateways;

import com.thiagosena.exercise2.application.web.payloads.response.CountryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "feignCountries", url = "https://fake-countries-api.herokuapp.com/countries")
public interface CountryGateway {
	@GetMapping
	List<CountryDto> getCountries();
}
