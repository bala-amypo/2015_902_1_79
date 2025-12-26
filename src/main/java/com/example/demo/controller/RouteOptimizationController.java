package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/optimize")
@RequiredArgsConstructor
public class RouteOptimizationController {
    
    private final RouteOptimizationService routeOptimizationService;
    
    @PostMapping("/{shipmentId}")
    public ApiResponse<RouteOptimizationResult> optimizeRoute(@PathVariable Long shipmentId) {
        RouteOptimizationResult result = routeOptimizationService.optimizeRoute(shipmentId);
        return ApiResponse.success(result);
    }
    
    @GetMapping("/result/{resultId}")
    public ApiResponse<RouteOptimizationResult> getResult(@PathVariable Long resultId) {
        RouteOptimizationResult result = routeOptimizationService.getResult(resultId);
        return ApiResponse.success(result);
    }
}