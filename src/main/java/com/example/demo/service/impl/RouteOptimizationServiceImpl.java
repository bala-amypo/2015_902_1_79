package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RouteOptimizationServiceImpl implements RouteOptimizationService {
    
    private final ShipmentRepository shipmentRepository;
    private final RouteOptimizationResultRepository resultRepository;
    
    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {
        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
        
        double pickupLat = shipment.getPickupLocation().getLatitude();
        double pickupLng = shipment.getPickupLocation().getLongitude();
        double dropLat = shipment.getDropLocation().getLatitude();
        double dropLng = shipment.getDropLocation().getLongitude();
        double fuelEfficiency = shipment.getVehicle().getFuelEfficiency();
        
        double distanceKm = Math.hypot(pickupLat - dropLat, pickupLng - dropLng) * 111; // Approx km
        double fuelUsageL = distanceKm / fuelEfficiency;
        
        RouteOptimizationResult result = RouteOptimizationResult.builder()
                .shipment(shipment)
                .optimizedDistanceKm(Math.max(1.0, distanceKm))
                .estimatedFuelUsageL(Math.max(0.1, fuelUsageL))
                .generatedAt(LocalDateTime.now())
                .build();
        
        return resultRepository.save(result);
    }
    
    @Override
    public RouteOptimizationResult getResult(Long resultId) {
        return resultRepository.findById(resultId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}