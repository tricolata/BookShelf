package com.springboot.bookshelfapp.repo;

import com.springboot.bookshelfapp.model.Book;
import com.springboot.bookshelfapp.model.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IBookRepo extends CrudRepository<Book, Long> {

    Optional<Book> findByAuthor(String author);
    List<Book> findByYearPublishedBetween(Integer start, Integer end);

    @Query("select b from Book b where b.yearPublished between ?1 AND ?2")
    List<Book> findByYearPublishedBetweenQuery(Integer start, Integer end);
}
