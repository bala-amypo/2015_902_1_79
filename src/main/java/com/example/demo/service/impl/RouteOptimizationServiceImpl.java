package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {
    private final ShipmentRepository shipmentRepository;
    private final RouteOptimizationResultRepository resultRepository;

    public RouteOptimizationServiceImpl(ShipmentRepository shipmentRepository, RouteOptimizationResultRepository resultRepository) {
        this.shipmentRepository = shipmentRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) throws ResourceNotFoundException {
        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        double lat1 = shipment.getPickupLocation().getLatitude();
        double lon1 = shipment.getPickupLocation().getLongitude();
        double lat2 = shipment.getDropLocation().getLatitude();
        double lon2 = shipment.getDropLocation().getLongitude();

        double distance = Math.hypot(lat2 - lat1, lon2 - lon1) * 111; // Dummy calculation
        if (distance <= 0) distance = 1.0; // Ensure positive

        double fuelUsage = distance / shipment.getVehicle().getFuelEfficiency();
        if (fuelUsage <= 0) fuelUsage = 0.1; // Ensure positive

        RouteOptimizationResult result = RouteOptimizationResult.builder()
                .shipment(shipment)
                .optimizedDistanceKm(distance)
                .estimatedFuelUsageL(fuelUsage)
                .generatedAt(LocalDateTime.now())
                .build();

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationResult getResult(Long resultId) throws ResourceNotFoundException {
        return resultRepository.findById(resultId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}