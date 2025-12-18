package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.repository.RouteOptimizationResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteOptimizationController {

    @Autowired
    private RouteOptimizationResultRepository routeRepository;

    @PostMapping
    public RouteOptimizationResult createResult(
            @RequestBody RouteOptimizationResult result) {
        return routeRepository.save(result);
    }

    @GetMapping
    public List<RouteOptimizationResult> getAllResults() {
        return routeRepository.findAll();
    }

    @GetMapping("/{id}")
    public RouteOptimizationResult getResultById(@PathVariable Long id) {
        return routeRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteResult(@PathVariable Long id) {
        routeRepository.deleteById(id);
    }
}