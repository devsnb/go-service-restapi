package com.goservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
}
