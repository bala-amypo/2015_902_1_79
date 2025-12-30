package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(unique = true)
    private String vehicleNumber;

    private Double capacityKg;
    private Double fuelEfficiency;

    public Vehicle() {}

    // ===== BUILDER =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Vehicle v = new Vehicle();

        public Builder id(Long id) {
            v.setId(id);
            return this;
        }

        public Builder user(User user) {
            v.setUser(user);
            return this;
        }

        public Builder vehicleNumber(String vehicleNumber) {
            v.setVehicleNumber(vehicleNumber);
            return this;
        }

        public Builder capacityKg(Double capacityKg) {
            v.setCapacityKg(capacityKg);
            return this;
        }

        public Builder fuelEfficiency(Double fuelEfficiency) {
            v.setFuelEfficiency(fuelEfficiency);
            return this;
        }

        public Vehicle build() {
            return v;
        }
    }

    // ===== getters & setters =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public Double getCapacityKg() { return capacityKg; }
    public void setCapacityKg(Double capacityKg) { this.capacityKg = capacityKg; }

    public Double getFuelEfficiency() { return fuelEfficiency; }
    public void setFuelEfficiency(Double fuelEfficiency) { this.fuelEfficiency = fuelEfficiency; }
}
