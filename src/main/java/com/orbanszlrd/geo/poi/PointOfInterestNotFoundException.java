package com.orbanszlrd.geo.poi;

import java.util.UUID;

public class PointOfInterestNotFoundException extends RuntimeException {
    public PointOfInterestNotFoundException(UUID id) {
        super(String.format("Poi '%s' not found!", id));
    }
}
