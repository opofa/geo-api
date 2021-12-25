package com.orbanszlrd.geo.service;

import com.orbanszlrd.geo.country.Country;
import com.orbanszlrd.geo.country.CountryRepository;
import com.orbanszlrd.geo.poi.PointOfInterest;
import com.orbanszlrd.geo.poi.PointOfInterestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class CountryImportService {
    private static final String URL = "https://restcountries.com/v2/all";

    private final RestTemplate restTemplate;
    private final CountryRepository countryRepository;
    private final PointOfInterestRepository pointOfInterestRepository;

    private Country[] getAll() {
        ResponseEntity<Country[]> response = restTemplate.getForEntity(URL, Country[].class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("API Error");
        }
    }

    public void fillDatabase() {
        long countryCount = countryRepository.count();

        if (countryCount == 0) {
            Country[] countries = getAll();

            log.info("Import " + countries.length + " Countries");

            Arrays.stream(countries).forEach(country -> {
                log.info("Import " + country);

                try {
                    country.setId(UUID.randomUUID());
                    Country c = countryRepository.save(country);
                    log.info(c + " imported successfully");

                    if (c.getCapital() != null)  {
                        PointOfInterest pointOfInterest = new PointOfInterest(UUID.randomUUID(), c.getCapital(), c.getName());
                        pointOfInterest.setType("Settlement");
                        pointOfInterestRepository.save(pointOfInterest);
                        log.info(pointOfInterest + " imported successfully");
                    }

                } catch (Exception e) {
                    log.warn(e.getMessage());
                }
            });
        } else {
            log.info(countryCount + " countries already in the database.");
        }

    }
}
