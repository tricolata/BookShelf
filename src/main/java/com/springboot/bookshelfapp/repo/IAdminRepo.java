package com.springboot.bookshelfapp.repo;

import com.springboot.bookshelfapp.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface IAdminRepo extends CrudRepository<Admin, Long> {
}
