package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Location;
import com.example.demo.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {
    
    private final LocationService locationService;
    
    @PostMapping
    public ApiResponse<Location> createLocation(@RequestBody Location location) {
        Location saved = locationService.createLocation(location);
        return ApiResponse.success(saved);
    }
    
    @GetMapping
    public ApiResponse<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return ApiResponse.success(locations);
    }
}