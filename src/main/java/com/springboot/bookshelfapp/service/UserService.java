package com.springboot.bookshelfapp.service;

import com.springboot.bookshelfapp.model.User;
import com.springboot.bookshelfapp.repo.IUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService implements IUserService {

    private IUserRepo repo;

    @Override
    public User getUser(Long userId, String password) {
        Optional<User> userOptional = repo.findUserByIdAndPassword(userId, password);
        userOptional.ifPresent(user -> user.setLoginStatus(true));
        return userOptional.orElse(null);
    }

    @Override
    public Boolean verifyLogin(Long userId) {
        return false;
    }
}
