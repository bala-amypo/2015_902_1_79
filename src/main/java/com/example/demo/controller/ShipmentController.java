package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Shipment;
import com.example.demo.service.ShipmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {
    
    private final ShipmentService shipmentService;
    
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }
    
    @PostMapping("/{vehicleId}")
    public ResponseEntity<ApiResponse> createShipment(@PathVariable Long vehicleId, @RequestBody Shipment shipment) {
        Shipment savedShipment = shipmentService.createShipment(vehicleId, shipment);
        return ResponseEntity.ok(new ApiResponse(true, "Shipment created successfully", savedShipment));
    }
    
    @GetMapping("/{shipmentId}")
    public ResponseEntity<Shipment> getShipment(@PathVariable Long shipmentId) {
        Shipment shipment = shipmentService.getShipment(shipmentId);
        return ResponseEntity.ok(shipment);
    }
}