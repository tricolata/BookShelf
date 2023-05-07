package com.springboot.bookshelfapp.repo;

import com.springboot.bookshelfapp.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface IAddressRepo extends CrudRepository<Address, Long> {
}
