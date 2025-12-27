package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/optimize")
public class RouteOptimizationController {
    private final RouteOptimizationService routeService;

    public RouteOptimizationController(RouteOptimizationService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/{shipmentId}")
    public ResponseEntity<RouteOptimizationResult> optimizeRoute(@PathVariable Long shipmentId) {
        RouteOptimizationResult result = routeService.optimizeRoute(shipmentId);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/result/{resultId}")
    public ResponseEntity<RouteOptimizationResult> getResult(@PathVariable Long resultId) {
        RouteOptimizationResult result = routeService.getResult(resultId);
        return ResponseEntity.ok(result);
    }
}
