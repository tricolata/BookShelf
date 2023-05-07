package com.springboot.bookshelfapp.service;

import com.springboot.bookshelfapp.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface IOrderService {

    public Order placeOrder();
}
