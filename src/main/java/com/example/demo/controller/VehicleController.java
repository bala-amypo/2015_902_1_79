package com.example.demo.controller;

import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    // Constructor injection (best practice)
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // Add a vehicle for a user
    @PostMapping(
            value = "/{userId}",
            consumes = "application/json",
            produces = "application/json"
    )
    public Vehicle addVehicle(
            @PathVariable Long userId,
            @RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(userId, vehicle);
    }

    // Get all vehicles for a user
    @GetMapping(
            value = "/user/{userId}",
            produces = "application/json"
    )
    public List<Vehicle> getVehiclesByUser(@PathVariable Long userId) {
        return vehicleService.getVehiclesByUser(userId);
    }
}
