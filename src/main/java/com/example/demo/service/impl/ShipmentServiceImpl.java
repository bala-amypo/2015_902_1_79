package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.entity.Shipment;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ShipmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;

    // ⚠️ MUST MATCH TEST
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository,
                               VehicleRepository vehicleRepository,
                               LocationRepository locationRepository) {
        this.shipmentRepository = shipmentRepository;
        this.vehicleRepository = vehicleRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public Shipment createShipment(Long vehicleId, Shipment shipment) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle not found"));

        if (shipment.getWeightKg() > vehicle.getCapacityKg()) {
            throw new IllegalArgumentException("Weight exceeds vehicle capacity");
        }

        if (shipment.getScheduledDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Date cannot be in the past");
        }

        Location pickup = locationRepository.findById(
                shipment.getPickupLocation().getId()
        ).orElseThrow(() ->
                new ResourceNotFoundException("Location not found"));

        Location drop = locationRepository.findById(
                shipment.getDropLocation().getId()
        ).orElseThrow(() ->
                new ResourceNotFoundException("Location not found"));

        shipment.setVehicle(vehicle);
        shipment.setPickupLocation(pickup);
        shipment.setDropLocation(drop);

        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment getShipment(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found"));
    }
}
