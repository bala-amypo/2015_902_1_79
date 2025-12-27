package com.example.demo.service;

import com.example.demo.entity.Shipment;
import com.example.demo.exception.ResourceNotFoundException;

public interface ShipmentService {
    Shipment createShipment(Long vehicleId, Shipment shipment) throws IllegalArgumentException, ResourceNotFoundException;
    Shipment getShipment(Long shipmentId) throws ResourceNotFoundException;
}
