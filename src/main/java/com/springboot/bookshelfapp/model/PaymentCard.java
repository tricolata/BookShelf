package com.springboot.bookshelfapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PaymentCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_card_id")
    private Long id;

    @Column(name = "card_type")
    private CardType creditCardType;

    @Column(name = "card_number")
    private Long cardNumber;

    @Column(name = "name_on_card")
    private String nameOnCard;

    @Column(name = "expiration_date")
    private Integer expirationDate;
}
