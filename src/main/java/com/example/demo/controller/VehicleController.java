package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    
    private final VehicleService vehicleService;
    
    @PostMapping("/{userId}")
    public ApiResponse<Vehicle> addVehicle(@PathVariable Long userId, @RequestBody Vehicle vehicle) {
        Vehicle saved = vehicleService.addVehicle(userId, vehicle);
        return ApiResponse.success(saved);
    }
    
    @GetMapping("/user/{userId}")
    public ApiResponse<List<Vehicle>> getVehiclesByUser(@PathVariable Long userId) {
        List<Vehicle> vehicles = vehicleService.getVehiclesByUser(userId);
        return ApiResponse.success(vehicles);
    }
}