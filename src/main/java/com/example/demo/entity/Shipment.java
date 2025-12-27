package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "shipments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pickup_location_id")
    private Location pickupLocation;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "drop_location_id")
    private Location dropLocation;

    @NotNull
    @Positive
    private Double weightKg;

    @NotNull
    private LocalDate scheduledDate;

    public Shipment(Vehicle vehicle, Location pickupLocation, Location dropLocation, Double weightKg, LocalDate scheduledDate) {
        this.vehicle = vehicle;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.weightKg = weightKg;
        this.scheduledDate = scheduledDate;
    }
}