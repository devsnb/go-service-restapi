package com.goservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(generator = "vehicle_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "vehicle_seq", sequenceName = "vehicle_sequence", allocationSize = 1)
    @Column(name = "vehicleid")
    private Integer vehicleId;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(length = 20, nullable = false)
    private String manufacturer;

    @Column(length = 20, nullable = false)
    private String model;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "vehicles")
    @JsonIgnore
    private List<ServiceCenter> serviceCenter;

    public Vehicle() {
    }

    public Vehicle(Category category, String manufacturer, String model, List<ServiceCenter> serviceCenter) {
        this.category = category;
        this.manufacturer = manufacturer;
        this.model = model;
        this.serviceCenter = serviceCenter;
    }

    public Vehicle(Integer vehicleId, Category category, String manufacturer, String model, List<ServiceCenter> serviceCenter) {
        this.vehicleId = vehicleId;
        this.category = category;
        this.manufacturer = manufacturer;
        this.model = model;
        this.serviceCenter = serviceCenter;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<ServiceCenter> getServiceCenter() {
        return serviceCenter;
    }

    public void setServiceCenter(List<ServiceCenter> serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", category=" + category +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", serviceCenter=" + serviceCenter +
                '}';
    }
}
