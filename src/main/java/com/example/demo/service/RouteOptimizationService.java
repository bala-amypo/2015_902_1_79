package com.example.demo.service;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.exception.ResourceNotFoundException;

public interface RouteOptimizationService {
    RouteOptimizationResult optimizeRoute(Long shipmentId) throws ResourceNotFoundException;
    RouteOptimizationResult getResult(Long resultId) throws ResourceNotFoundException;
}