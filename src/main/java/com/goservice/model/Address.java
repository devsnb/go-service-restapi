package com.goservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
}
