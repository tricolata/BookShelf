package com.springboot.bookshelfapp.service;

import org.springframework.stereotype.Service;

@Service
public interface IAdminService {

    public Boolean addCategory();
    public Boolean deleteCategory();
    public Boolean addCustomer();
    public Boolean deleteCustomer();
    public Boolean addBook();
    public Boolean deleteBook();
    public Boolean addCreditCardType();
    public Boolean deleteCreditCardType();
}
