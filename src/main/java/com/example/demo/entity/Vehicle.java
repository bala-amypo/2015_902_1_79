package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "vehicles", uniqueConstraints = {
    @UniqueConstraint(columnNames = "vehicleNumber")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(unique = true)
    private String vehicleNumber;

    @NotNull
    @Positive
    private Double capacityKg;

    @NotNull
    @Positive
    private Double fuelEfficiency;

    public Vehicle(User user, String vehicleNumber, Double capacityKg, Double fuelEfficiency) {
        this.user = user;
        this.vehicleNumber = vehicleNumber;
        this.capacityKg = capacityKg;
        this.fuelEfficiency = fuelEfficiency;
    }
}