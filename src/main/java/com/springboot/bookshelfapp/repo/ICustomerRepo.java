package com.springboot.bookshelfapp.repo;

import com.springboot.bookshelfapp.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepo extends CrudRepository<Customer, Long> {
}
