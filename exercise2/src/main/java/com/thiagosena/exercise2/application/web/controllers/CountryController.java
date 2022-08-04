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

@RestController
@RequestMapping("api/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/total")
    @Cacheable("total-countries-world")
    public ResponseEntity<CountryTotalDto> getTotalCountriesWorld() {
        return ResponseEntity.ok(countryService.getTotalCountriesWorld());
    }

    @GetMapping("/most-language-where-speak/{language}")
    public ResponseEntity<CountryDto> getCountryMostLanguagesAndSpeakGerman(
            @PathVariable("language") String language) {
        return ResponseEntity.ok(countryService.getCountryMostLanguagesAndSpeakGerman(language));
    }

    @GetMapping("/total-languages")
    public ResponseEntity<CountryTotalDto> getTotalLanguagesWorld() {
        return ResponseEntity.ok(countryService.getTotalLanguagesWorld());
    }

    @GetMapping("/more-languages")
    public ResponseEntity<CountryDto> getCountryWithMoreLanguages() {
        return ResponseEntity.ok(countryService.getCountryWithMoreLanguages());
    }

    @GetMapping("/common-languages")
    public ResponseEntity<CountryDto> getCommonLanguages() {
        return ResponseEntity.ok(countryService.getCountryWithMoreLanguages());
    }
}
