package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/optimize")
public class RouteOptimizationController {
    
    private final RouteOptimizationService routeOptimizationService;
    
    public RouteOptimizationController(RouteOptimizationService routeOptimizationService) {
        this.routeOptimizationService = routeOptimizationService;
    }
    
    @PostMapping("/{shipmentId}")
    public ResponseEntity<ApiResponse> optimizeRoute(@PathVariable Long shipmentId) {
        RouteOptimizationResult result = routeOptimizationService.optimizeRoute(shipmentId);
        return ResponseEntity.ok(new ApiResponse(true, "Route optimized successfully", result));
    }
    
    @GetMapping("/result/{resultId}")
    public ResponseEntity<RouteOptimizationResult> getResult(@PathVariable Long resultId) {
        RouteOptimizationResult result = routeOptimizationService.getResult(resultId);
        return ResponseEntity.ok(result);
    }
}