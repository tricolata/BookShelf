package com.springboot.bookshelfapp.repo;

import com.springboot.bookshelfapp.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ICategoryRepo extends CrudRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
