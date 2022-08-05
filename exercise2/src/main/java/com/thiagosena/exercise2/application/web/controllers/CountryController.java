package com.thiagosena.exercise2.application.web.controllers;

import com.thiagosena.exercise2.application.exceptions.ErrorResponse;
import com.thiagosena.exercise2.application.web.payloads.response.CountryDto;
import com.thiagosena.exercise2.application.web.payloads.response.CountryTotalDto;
import com.thiagosena.exercise2.domain.services.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    @Operation(summary = "Total of countries in the world",
            description = "Provides the number of countries in the world.")
    @ApiResponse(responseCode = "200", description = "Returned total of countries in the world")
    @ApiResponse(responseCode = "404", description = "Bad Request - make sure all required fields are entered.",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class))}
    )
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class))}
    )
    public ResponseEntity<CountryTotalDto> getTotalCountriesWorld() {
        return ResponseEntity.ok(countryService.getTotalCountriesWorld());
    }

    @GetMapping("/most-language-where-speak/{language}")
    @Operation(summary = "Get country with the most languages where speak German",
            description = "Finds the country with the most official languages, where they officially speak German (de).")
    @ApiResponse(responseCode = "200", description = "Returned country")
    @ApiResponse(responseCode = "404", description = "Bad Request - make sure all required fields are entered.",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class))}
    )
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class))}
    )
    public ResponseEntity<CountryDto> getCountryMostLanguagesAndSpeakGerman(
            @PathVariable("language") String language) {
        return ResponseEntity.ok(countryService.getCountryMostLanguagesAndSpeakGerman(language));
    }

    @GetMapping("/total-languages")
    @Operation(summary = "Total of languages in the world",
            description = "Counts all the official languages spoken in the listed countries.")
    @ApiResponse(responseCode = "200", description = "Returned total of languages")
    @ApiResponse(responseCode = "404", description = "Bad Request - make sure all required fields are entered.",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class))}
    )
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class))}
    )
    public ResponseEntity<CountryTotalDto> getTotalLanguagesWorld() {
        return ResponseEntity.ok(countryService.getTotalLanguagesWorld());
    }

    @GetMapping("/more-languages")
    @Operation(summary = "Get country that have more languages",
            description = "Find the country with the highest number of official languages.")
    @ApiResponse(responseCode = "200", description = "Returned country")
    @ApiResponse(responseCode = "404", description = "Bad Request - make sure all required fields are entered.",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class))}
    )
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class))}
    )
    public ResponseEntity<CountryDto> getCountryWithMoreLanguages() {
        return ResponseEntity.ok(countryService.getCountryWithMoreLanguages());
    }

    @GetMapping("/common-languages")
    @Operation(summary = "Get a list of the most common languages of all countries",
            description = "Find the most common official language(s), of all countries.")
    @ApiResponse(responseCode = "200", description = "Returned languages")
    @ApiResponse(responseCode = "404", description = "Bad Request - make sure all required fields are entered.",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class))}
    )
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class))}
    )
    public ResponseEntity<Map<String, Long>> getMostCommonLanguagesAllCountries() {
        return ResponseEntity.ok(countryService.getMostCommonLanguagesAllCountries());
    }
}
