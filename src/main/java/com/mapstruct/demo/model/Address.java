package com.mapstruct.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    private String streetAddress;

    private String streetAddress2;

    private String city;

    private String state;

    private String zipCode;

    private String country;

    private String status;

    private Boolean isDefault;

}
