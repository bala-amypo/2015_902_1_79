package com.example.demo.repository;

import com.example.demo.entity.RouteOptimizationResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteOptimizationResultRepository
        extends JpaRepository<RouteOptimizationResult, Long> {

    List<RouteOptimizationResult> findByShipmentId(Long shipmentId);
}