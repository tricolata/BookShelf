package com.springboot.bookshelfapp.service;

import org.springframework.stereotype.Service;

@Service
public interface ICustomerService {

    public Boolean register();
    public Boolean login();
    public Boolean updateProfile();
}
