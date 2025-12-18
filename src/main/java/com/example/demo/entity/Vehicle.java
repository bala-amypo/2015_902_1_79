package com.example.demo.entity;
import jakarta.persistence.*;
@Entity

public class Vehicle{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @Column(unique=true,nullable=false)
    private String vehicleNumber;
    private Double capacityKg;
    private Double fuelEfficiency;
    public Vehicle(){}    
    public Vehicle(Long id,User user,String vehicleNumber,Double capacityKg)
    
}