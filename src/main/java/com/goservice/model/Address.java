package com.goservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(generator = "address_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "address_seq", sequenceName = "address_sequence", allocationSize = 1)
    @Column(name = "addressid")
    private Integer addressId;

    @Column(length = 20)
    private String locality;

    @Column(length = 20)
    private String city;

    @Column(length = 20)
    private String state;

    @Column
    private int zipcode;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private ServiceCenter center;

    public Address() {
    }

    public Address(Integer addressId, String locality, String city, String state, int zipcode, ServiceCenter center) {
        this.addressId = addressId;
        this.locality = locality;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.center = center;
    }

    public Address(String locality, String city, String state, int zipcode, ServiceCenter center) {
        this.locality = locality;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.center = center;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public ServiceCenter getCenter() {
        return center;
    }

    public void setCenter(ServiceCenter center) {
        this.center = center;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", locality='" + locality + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", center=" + center +
                '}';
    }
}
