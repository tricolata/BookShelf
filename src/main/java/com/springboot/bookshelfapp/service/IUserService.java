package com.springboot.bookshelfapp.service;

import com.springboot.bookshelfapp.model.User;

public interface IUserService {

//    public Category getCategory();
    public User getUser(Long userId, String password);
    public Boolean verifyLogin(Long userId);
}
