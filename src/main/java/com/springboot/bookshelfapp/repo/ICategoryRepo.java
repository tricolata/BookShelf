package com.springboot.bookshelfapp.repo;

import com.springboot.bookshelfapp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepo extends CrudRepository<Category, Long> {
}
