package com.example.demo.controller;

import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Vehicle> addVehicle(@PathVariable Long userId, @RequestBody Vehicle vehicle) {
        Vehicle savedVehicle = vehicleService.addVehicle(userId, vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVehicle);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Vehicle>> getVehiclesByUser(@PathVariable Long userId) {
        List<Vehicle> vehicles = vehicleService.getVehiclesByUser(userId);
        return ResponseEntity.ok(vehicles);
    }
}