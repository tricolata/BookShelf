package com.springboot.bookshelfapp.service;

import com.springboot.bookshelfapp.model.Member;

public interface IMemberService {

    // User
    public Member login(String userId, String password);
    public Boolean verifyLogin(String userId);
}
