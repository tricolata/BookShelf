package com.springboot.bookshelfapp.model;

/*
    Contains the Members Information
 */

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_login")
    private String memberLogin;

    @Column(name = "member_password")
    private String memberPassword;

    @Column(name = "member_level")
    private MemberLevel memberLevel;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Set<Address> addresses;

    private String notes;

    @OneToOne
    @JoinColumn(name = "payment_card_id")
    private PaymentCard paymentCard;
}
