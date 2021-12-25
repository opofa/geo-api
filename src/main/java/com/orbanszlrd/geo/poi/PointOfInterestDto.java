package com.orbanszlrd.geo.poi;

import lombok.Data;

import java.util.UUID;

@Data
public class PointOfInterestDto {
    private UUID id;
    private String name;
    private String type;
    private String countryName;
    private Float latitude;
    private Float longitude;
    private Float altitude;
}
