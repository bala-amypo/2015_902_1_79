package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double latitude;
    private Double longitude;

    public Location() {}

    // ===== BUILDER =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Location l = new Location();

        public Builder id(Long id) {
            l.setId(id);
            return this;
        }

        public Builder name(String name) {
            l.setName(name);
            return this;
        }

        public Builder latitude(Double latitude) {
            l.setLatitude(latitude);
            return this;
        }

        public Builder longitude(Double longitude) {
            l.setLongitude(longitude);
            return this;
        }

        public Location build() {
            return l;
        }
    }

    // ===== getters & setters =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
}
