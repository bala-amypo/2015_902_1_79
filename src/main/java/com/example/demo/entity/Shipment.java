package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "shipments")
public class Shipment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    
    @ManyToOne
    @JoinColumn(name = "pickup_location_id")
    private Location pickupLocation;
    
    @ManyToOne
    @JoinColumn(name = "drop_location_id")
    private Location dropLocation;
    
    private Double weightKg;
    
    private LocalDate scheduledDate;
    
    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
    private List<RouteOptimizationResult> routeResults;
    
    public Shipment() {}
    
    public Shipment(Vehicle vehicle, Location pickupLocation, Location dropLocation, Double weightKg, LocalDate scheduledDate) {
        this.vehicle = vehicle;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.weightKg = weightKg;
        this.scheduledDate = scheduledDate;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    
    public Location getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(Location pickupLocation) { this.pickupLocation = pickupLocation; }
    
    public Location getDropLocation() { return dropLocation; }
    public void setDropLocation(Location dropLocation) { this.dropLocation = dropLocation; }
    
    public Double getWeightKg() { return weightKg; }
    public void setWeightKg(Double weightKg) { this.weightKg = weightKg; }
    
    public LocalDate getScheduledDate() { return scheduledDate; }
    public void setScheduledDate(LocalDate scheduledDate) { this.scheduledDate = scheduledDate; }
    
    public List<RouteOptimizationResult> getRouteResults() { return routeResults; }
    public void setRouteResults(List<RouteOptimizationResult> routeResults) { this.routeResults = routeResults; }
}