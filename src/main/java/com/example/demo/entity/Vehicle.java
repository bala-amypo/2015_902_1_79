package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(unique = true, nullable = false)
    private String vehicleNumber;

    private Double capacityKg;

    private Double fuelEfficiency; // km per liter

    public Vehicle() {}

    public Vehicle(Long id, User user, String vehicleNumber, Double capacityKg, Double fuelEfficiency) {
        this.id = id;
        this.user = user;
        this.vehicleNumber = vehicleNumber;
        this.capacityKg = capacityKg;
        this.fuelEfficiency = fuelEfficiency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
    public String getVehicleNumber() {
        return vehicleNumber;
    }
 
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
 
    public Double getCapacityKg() {
        return capacityKg;
    }
 
    public void setCapacityKg(Double capacityKg) {
        this.capacityKg = capacityKg;
    }
 
    public Double getFuelEfficiency() {
        return fuelEfficiency;
    }
 
    public void setFuelEfficiency(Double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }
}