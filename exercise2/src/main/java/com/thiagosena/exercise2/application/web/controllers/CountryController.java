package com.thiagosena.exercise2.application.web.controllers;

import com.thiagosena.exercise2.domain.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/total-countries-world")
    @Cacheable("total-countries-world")
    public ResponseEntity<Integer> getTotalCountriesWorld() {
        return ResponseEntity.ok(countryService.getTotalCountriesWorld());
    }
}
