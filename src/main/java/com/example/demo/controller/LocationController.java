package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Location;
import com.example.demo.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    
    private final LocationService locationService;
    
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    
    @PostMapping
    public ResponseEntity<ApiResponse> createLocation(@RequestBody Location location) {
        Location savedLocation = locationService.createLocation(location);
        return ResponseEntity.ok(new ApiResponse(true, "Location created successfully", savedLocation));
    }
    
    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }
}