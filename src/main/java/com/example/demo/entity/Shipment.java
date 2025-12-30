package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "shipment")
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

    private Double weightKg;
    private LocalDate scheduledDate;

    public Shipment() {}

    // ===== BUILDER =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Shipment s = new Shipment();

        public Builder id(Long id) {
            s.setId(id);
            return this;
        }

        public Builder vehicle(Vehicle vehicle) {
            s.setVehicle(vehicle);
            return this;
        }

        public Builder pickupLocation(Location pickupLocation) {
            s.setPickupLocation(pickupLocation);
            return this;
        }

        public Builder dropLocation(Location dropLocation) {
            s.setDropLocation(dropLocation);
            return this;
        }

        public Builder weightKg(Double weightKg) {
            s.setWeightKg(weightKg);
            return this;
        }

        public Builder scheduledDate(LocalDate scheduledDate) {
            s.setScheduledDate(scheduledDate);
            return this;
        }

        public Shipment build() {
            return s;
        }
    }

    // ===== getters & setters =====
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
}
