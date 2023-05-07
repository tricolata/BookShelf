package com.springboot.bookshelfapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerId")
    private Long id;
    private String name;
    private String email;
    private String password;
    private Integer phoneNumber;
    private String creditCardInfo;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
