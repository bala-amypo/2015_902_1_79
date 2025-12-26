package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    
    private final LocationRepository locationRepository;
    
    @Override
    public Location createLocation(Location location) {
        if (location.getLatitude() < -90 || location.getLatitude() > 90) {
            throw new IllegalArgumentException("Invalid latitude value");
        }
        return locationRepository.save(location);
    }
    
    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}