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
public class Service {

    @Id
    @GeneratedValue(generator = "service_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "service_seq", sequenceName = "service_sequence", allocationSize = 1)
    @Column(name = "serviceid")
    private Integer typeId;

    @Enumerated(EnumType.STRING)
    private ServiceType name;

    @ManyToOne
    @JoinColumn(name = "servicecenterid")
    @JsonIgnore
    private ServiceCenter serviceCenters;

}
