package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Shipment;
import com.example.demo.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipments")
@RequiredArgsConstructor
public class ShipmentController {
    
    private final ShipmentService shipmentService;
    
    @PostMapping("/{vehicleId}")
    public ApiResponse<Shipment> createShipment(@PathVariable Long vehicleId, @RequestBody Shipment shipment) {
        Shipment saved = shipmentService.createShipment(vehicleId, shipment);
        return ApiResponse.success(saved);
    }
    
    @GetMapping("/{shipmentId}")
    public ApiResponse<Shipment> getShipment(@PathVariable Long shipmentId) {
        Shipment shipment = shipmentService.getShipment(shipmentId);
        return ApiResponse.success(shipment);
    }
}