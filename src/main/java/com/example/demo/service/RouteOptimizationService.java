package com.example.demo.service;

import com.example.demo.entity.RouteOptimizationResult;

public interface RouteOptimizationService {
    RouteOptimizationResult optimizeRoute(Long shipmentId);
    RouteOptimizationResult getResult(Long resultId);
}