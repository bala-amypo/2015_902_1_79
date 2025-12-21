package com.example.demo.service;

import com.example.demo.entity.Vehicle;
import java.util.List;

public interface VehicleService {
    Vehicle addVehicle(Long userId, Vehicle vehicle);
    List<Vehicle> getVehiclesByUser(Long userId);
    Vehicle findById(Long id);
}