package com.orbanszlrd.geo.country;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final ModelMapper modelMapper;
    private final CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country add(SaveCountryCommand saveCountryCommand) {
        Country country = modelMapper.map(saveCountryCommand, Country.class);
        country.setId(UUID.randomUUID());
        return countryRepository.save(country);
    }

    public Country update(UUID id, SaveCountryCommand saveCountryCommand) {
        Country oldCountry = findById(id);
        Country country = modelMapper.map(saveCountryCommand, Country.class);
        country.setId(oldCountry.getId());
        return countryRepository.save(country);
    }

    public Country findById(UUID id) {
        return countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
    }

    public void deleteById(UUID id) {
        countryRepository.deleteById(id);
    }
}
