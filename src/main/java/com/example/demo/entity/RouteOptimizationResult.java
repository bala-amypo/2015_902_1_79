package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "route_optimization_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteOptimizationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    @NotNull
    @Positive
    private Double optimizedDistanceKm;

    @NotNull
    @Positive
    private Double estimatedFuelUsageL;

    @NotNull
    private LocalDateTime generatedAt;

    public RouteOptimizationResult(Shipment shipment, Double optimizedDistanceKm, Double estimatedFuelUsageL, LocalDateTime generatedAt) {
        this.shipment = shipment;
        this.optimizedDistanceKm = optimizedDistanceKm;
        this.estimatedFuelUsageL = estimatedFuelUsageL;
        this.generatedAt = generatedAt;
    }

    @PrePersist
    protected void onCreate() {
        generatedAt = LocalDateTime.now();
    }
}