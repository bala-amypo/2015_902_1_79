package com.example.demo.repository;

import com.example.demo.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByUserId(Long userId);

    Optional<Vehicle> findByVehicleNumber(String vehicleNumber);
}