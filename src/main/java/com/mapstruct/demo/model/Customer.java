package com.mapstruct.demo.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String cpf;

    private String firstName;

    private String lastName;

    private LocalDate customerSince;

    private String email;

    private String phoneNumber;

    private String alternativePhoneNumber;

    private LocalDate birthDay;

    @Enumerated(value = EnumType.STRING)
    private ShipMethod defaultShipMethod;

    private Boolean emailNotification;

    private Boolean newsletter;

    private String alias;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Address> address;

}
