package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    
    @Override
    public Vehicle addVehicle(Long userId, Vehicle vehicle) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        if (vehicle.getCapacityKg() == null || vehicle.getCapacityKg() <= 0) {
            throw new IllegalArgumentException("Capacity cannot be zero or negative");
        }
        
        vehicle.setUser(user);
        return vehicleRepository.save(vehicle);
    }
    
    @Override
    public List<Vehicle> getVehiclesByUser(Long userId) {
        return vehicleRepository.findByUserId(userId);
    }
    
    @Override
    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
    }
}