package com.springboot.bookshelfapp.service;

import org.springframework.stereotype.Service;

@Service
public interface IBookService {

    public Boolean placeOrder(Long orderId, Double price, Long customerId, Integer quantity);


}
