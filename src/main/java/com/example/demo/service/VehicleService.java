package com.example.demo.service;

import com.example.demo.entity.Vehicle;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;

public interface VehicleService {
    Vehicle addVehicle(Long userId, Vehicle vehicle) throws IllegalArgumentException, ResourceNotFoundException;
    List<Vehicle> getVehiclesByUser(Long userId) throws ResourceNotFoundException;
    Vehicle findById(Long vehicleId) throws ResourceNotFoundException;
}