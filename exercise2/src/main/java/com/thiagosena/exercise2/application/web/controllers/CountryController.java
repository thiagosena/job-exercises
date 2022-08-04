package com.thiagosena.exercise2.application.web.controllers;

import com.thiagosena.exercise2.application.web.payloads.response.CountryDto;
import com.thiagosena.exercise2.application.web.payloads.response.CountryTotalDto;
import com.thiagosena.exercise2.domain.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<CountryTotalDto> getTotalCountriesWorld() {
        return ResponseEntity.ok(countryService.getTotalCountriesWorld());
    }

    @GetMapping("/countries-speak-language/{language}")
    public ResponseEntity<List<CountryDto>> getCountriesSpeakGerman(
            @PathVariable("language") String language) {
        return ResponseEntity.ok(countryService.getCountriesSpeakLanguage(language));
    }

    @GetMapping("/total-languages-world")
    public ResponseEntity<CountryTotalDto> getTotalLanguagesWorld() {
        return ResponseEntity.ok(countryService.getTotalLanguagesWorld());
    }
}
