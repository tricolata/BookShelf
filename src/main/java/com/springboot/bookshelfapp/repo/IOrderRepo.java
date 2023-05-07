package com.springboot.bookshelfapp.repo;

import com.springboot.bookshelfapp.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface IOrderRepo extends CrudRepository<Order, Long> {
}
