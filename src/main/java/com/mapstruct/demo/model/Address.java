package com.mapstruct.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
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
