package com.example.demo.controller;

import com.example.demo.entity.Shipment;
import com.example.demo.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    // Constructor injection (mandatory)
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    // Create Shipment for a Vehicle
    @PostMapping(
            value = "/{vehicleId}",
            consumes = "application/json",
            produces = "application/json"
    )
    public Shipment createShipment(
            @PathVariable Long vehicleId,
            @RequestBody Shipment shipment) {
        return shipmentService.createShipment(vehicleId, shipment);
    }

    // Get Shipment by ID
    @GetMapping(
            value = "/{shipmentId}",
            produces = "application/json"
    )
    public Shipment getShipment(@PathVariable Long shipmentId) {
        return shipmentService.getShipment(shipmentId);
    }
}
