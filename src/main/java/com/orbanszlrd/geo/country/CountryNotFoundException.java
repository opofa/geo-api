package com.orbanszlrd.geo.country;

import java.util.UUID;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(UUID id) {
        super(String.format("Country '%s' not found!", id));
    }
}