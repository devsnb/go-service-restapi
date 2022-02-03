package com.goservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "servicecenter")
public class ServiceCenter {

    @Id
    @GeneratedValue(generator = "service_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "service_seq", sequenceName = "service_center_seq", allocationSize = 1)
    @Column(name = "servicecenterid")
    private Integer serviceCenterId;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(nullable = false)
    private double rating;

    @Column(name = "avgduration", length = 20, nullable = false)
    private String avgDuration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressid")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "serviceid")
    @ToString.Exclude
    private Set<Service> services;

    @Column
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "servicecenter_vehicle",
            joinColumns = @JoinColumn(name = "servicecenterid"),
            inverseJoinColumns = @JoinColumn(name = "vehicleid")
    )
    @ToString.Exclude
    private Set<Vehicle> vehicles;

    public ServiceCenter(Integer serviceCenterId, String name, double rating, String avgDuration, Address address, Set<Service> services, Set<Vehicle> vehicles) {
        this.serviceCenterId = serviceCenterId;
        this.name = name;
        this.rating = rating;
        this.avgDuration = avgDuration;
        this.address = address;
        this.services = services;
        this.vehicles = vehicles;
    }

    public ServiceCenter() {
    }

    public ServiceCenter(String name, double rating, String avgDuration, Address address, Set<Service> services, Set<Vehicle> vehicles) {
        this.name = name;
        this.rating = rating;
        this.avgDuration = avgDuration;
        this.address = address;
        this.services = services;
        this.vehicles = vehicles;
    }

    public Integer getServiceCenterId() {
        return serviceCenterId;
    }

    public void setServiceCenterId(Integer serviceCenterId) {
        this.serviceCenterId = serviceCenterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAvgDuration() {
        return avgDuration;
    }

    public void setAvgDuration(String avgDuration) {
        this.avgDuration = avgDuration;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "ServiceCenter{" +
                "serviceCenterId=" + serviceCenterId +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", avgDuration='" + avgDuration + '\'' +
                ", address=" + address +
                ", services=" + services +
                '}';
    }
}
