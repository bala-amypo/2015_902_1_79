package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.entity.Shipment;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {
    
    private final ShipmentRepository shipmentRepository;
    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;
    
    @Override
    public Shipment createShipment(Long vehicleId, Shipment shipment) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
        
        Location pickupLocation = locationRepository.findById(shipment.getPickupLocation().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Pickup location not found"));
        
        Location dropLocation = locationRepository.findById(shipment.getDropLocation().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Drop location not found"));
        
        if (shipment.getWeightKg() > vehicle.getCapacityKg()) {
            throw new IllegalArgumentException("Shipment weight exceeds vehicle capacity");
        }
        
        if (shipment.getScheduledDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Scheduled date cannot be in the past");
        }
        
        shipment.setVehicle(vehicle);
        shipment.setPickupLocation(pickupLocation);
        shipment.setDropLocation(dropLocation);
        
        return shipmentRepository.save(shipment);
    }
    
    @Override
    public Shipment getShipment(Long shipmentId) {
        return shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
    }
}