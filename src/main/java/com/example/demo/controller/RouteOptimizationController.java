package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/optimize")
public class RouteOptimizationController {

    private final RouteOptimizationService routeOptimizationService;

    // Constructor injection
    public RouteOptimizationController(RouteOptimizationService routeOptimizationService) {
        this.routeOptimizationService = routeOptimizationService;
    }

    // Optimize route for a shipment
    @PostMapping(
            value = "/{shipmentId}",
            produces = "application/json"
    )
    public RouteOptimizationResult optimizeRoute(
            @PathVariable Long shipmentId) {
        return routeOptimizationService.optimizeRoute(shipmentId);
    }
}