package com.goservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
}
