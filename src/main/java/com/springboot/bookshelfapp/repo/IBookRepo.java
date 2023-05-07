package com.springboot.bookshelfapp.repo;

import com.springboot.bookshelfapp.model.Book_old;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IBookRepo extends CrudRepository<Book_old, Long> {

    Optional<Book_old> findByAuthor(String author);
    List<Book_old> findByYearPublishedBetween(Integer start, Integer end);

    @Query("select b from Book_old b where b.yearPublished between ?1 AND ?2")
    List<Book_old> findByYearPublishedBetweenQuery(Integer start, Integer end);
}
