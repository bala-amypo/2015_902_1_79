package com.example.demo.service;

import com.example.demo.entity.Location;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;

public interface LocationService {
    Location createLocation(Location location) throws IllegalArgumentException;
    List<Location> getAllLocations();
    Location findById(Long locationId) throws ResourceNotFoundException;
}