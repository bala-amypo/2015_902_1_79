package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Location pickupLocation;

    @ManyToOne
    private Location dropLocation;

    private Double weight;

    private LocalDate scheduledDate;

    public Shipment() {}

    public Shipment(Long id, Vehicle vehicle, Location pickupLocation,
                    Location dropLocation, Double weight, LocalDate scheduledDate) {
        this.id = id;
        this.vehicle = vehicle;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.weight = weight;
        this.scheduledDate = scheduledDate;
    }

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public Vehicle getVehicle() {
        return vehicle;
    }
 
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
 
    public Location getPickupLocation() {
        return pickupLocation;
    }
 
    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }
 
    public Location getDropLocation() {
        return dropLocation;
    }
 
    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }
 
    public Double getWeight() {
        return weight;
    }
 
    public void setWeight(Double weight) {
        this.weight = weight;
    }
 
    public LocalDate getScheduledDate() {
        return scheduledDate;
    }
 
    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }
}