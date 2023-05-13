package com.springboot.bookshelfapp.repo;

import com.springboot.bookshelfapp.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface IItemRepo extends CrudRepository<Item, Long> {
}
