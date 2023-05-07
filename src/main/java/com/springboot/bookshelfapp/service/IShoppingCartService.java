package com.springboot.bookshelfapp.service;

import org.springframework.stereotype.Service;

@Service
public interface IShoppingCartService {

    public Boolean addCart(Long orderId, Long customerId);
    public Boolean deleteCart(Long orderId, Long customerId);
    public Boolean updateCart();
}
