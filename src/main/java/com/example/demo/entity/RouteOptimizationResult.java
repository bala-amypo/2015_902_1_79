package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Shipment shipment;

    private Double optimizedDistanceKm;

    private Double estimatedFuelUsageL;

    private LocalDateTime generatedAt;

    // ---------- getters & setters ----------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Double getOptimizedDistanceKm() {
        return optimizedDistanceKm;
    }

    public void setOptimizedDistanceKm(Double optimizedDistanceKm) {
        this.optimizedDistanceKm = optimizedDistanceKm;
    }

    public Double getEstimatedFuelUsageL() {
        return estimatedFuelUsageL;
    }

    public void setEstimatedFuelUsageL(Double estimatedFuelUsageL) {
        this.estimatedFuelUsageL = estimatedFuelUsageL;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    // ---------- MANUAL BUILDER (IMPORTANT) ----------

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final RouteOptimizationResult r = new RouteOptimizationResult();

        public Builder id(Long id) {
            r.setId(id);
            return this;
        }

        public Builder shipment(Shipment shipment) {
            r.setShipment(shipment);
            return this;
        }

        public Builder optimizedDistanceKm(Double d) {
            r.setOptimizedDistanceKm(d);
            return this;
        }

        public Builder estimatedFuelUsageL(Double f) {
            r.setEstimatedFuelUsageL(f);
            return this;
        }

        public Builder generatedAt(LocalDateTime t) {
            r.setGeneratedAt(t);
            return this;
        }

        public RouteOptimizationResult build() {
            return r;
        }
    }
}
