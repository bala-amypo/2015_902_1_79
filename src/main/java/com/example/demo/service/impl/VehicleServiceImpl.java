package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, UserRepository userRepository) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Vehicle addVehicle(Long userId, Vehicle vehicle) throws IllegalArgumentException, ResourceNotFoundException {
        if (vehicle.getCapacityKg() <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        vehicle.setUser(user);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getVehiclesByUser(Long userId) throws ResourceNotFoundException {
        return vehicleRepository.findByUserId(userId);
    }

    @Override
    public Vehicle findById(Long vehicleId) throws ResourceNotFoundException {
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
    }
}

