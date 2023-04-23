package com.springboot.bookshelfapp.repo;

import com.springboot.bookshelfapp.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface IGenreRepo extends CrudRepository<Genre, Long> {
}
