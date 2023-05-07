package com.springboot.bookshelfapp.repo;

import com.springboot.bookshelfapp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUserRepo extends CrudRepository<User, Long> {
    Optional<User> findUserByIdAndPassword(Long userId, String password);
}
