package com.thiagosena.exercise2.application.web.payloads.response;

import java.util.List;

public record CountryDto(String country, List<String> languages) {

}
