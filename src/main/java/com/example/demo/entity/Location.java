package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private Double latitude;
    
    private Double longitude;
    
    @OneToMany(mappedBy = "pickupLocation")
    private List<Shipment> pickupShipments;
    
    @OneToMany(mappedBy = "dropLocation")
    private List<Shipment> dropShipments;
    
    public Location() {}
    
    public Location(String name, Double latitude, Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    
    public List<Shipment> getPickupShipments() { return pickupShipments; }
    public void setPickupShipments(List<Shipment> pickupShipments) { this.pickupShipments = pickupShipments; }
    
    public List<Shipment> getDropShipments() { return dropShipments; }
    public void setDropShipments(List<Shipment> dropShipments) { this.dropShipments = dropShipments; }
}