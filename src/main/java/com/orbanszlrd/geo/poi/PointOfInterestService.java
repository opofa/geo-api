package com.orbanszlrd.geo.poi;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PointOfInterestService {
    private final ModelMapper modelMapper;
    private final PointOfInterestRepository pointOfInterestRepository;

    public List<PointOfInterestDto> findAll() {
        Type type = new TypeToken<List<PointOfInterestDto>>() {
        }.getType();

        List<PointOfInterest> pointsOfInterest = pointOfInterestRepository.findAll();
        return modelMapper.map(pointsOfInterest, type);
    }

    public PointOfInterestDto add(SavePointOfInterestCommand savePointOfInterestCommand) {
        PointOfInterest pointOfInterest =  modelMapper.map(savePointOfInterestCommand, PointOfInterest.class);
        pointOfInterest.setId(UUID.randomUUID());
        pointOfInterestRepository.save(pointOfInterest);
        return modelMapper.map(pointOfInterest, PointOfInterestDto.class);
    }

    public PointOfInterestDto update(UUID id, SavePointOfInterestCommand savePointOfInterestCommand) {
        PointOfInterest oldPointOfInterest = pointOfInterestRepository.findById(id).orElseThrow(() -> new PointOfInterestNotFoundException(id));
        PointOfInterest pointOfInterest = modelMapper.map(savePointOfInterestCommand, PointOfInterest.class);
        pointOfInterest.setId(id);
        pointOfInterest.setCreateDate(oldPointOfInterest.getCreateDate());

        pointOfInterest = pointOfInterestRepository.save(pointOfInterest);

        return modelMapper.map(pointOfInterest, PointOfInterestDto.class);
    }

    public PointOfInterestDto findById(UUID id) {
        PointOfInterest pointOfInterest = pointOfInterestRepository.findById(id).orElseThrow(() -> new PointOfInterestNotFoundException(id));
        return modelMapper.map(pointOfInterest, PointOfInterestDto.class);
    }

    public void deleteById(UUID id) {
        pointOfInterestRepository.deleteById(id);
    }
}
