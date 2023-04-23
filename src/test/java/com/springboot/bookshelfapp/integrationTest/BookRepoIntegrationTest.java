package com.springboot.bookshelfapp.integrationTest;

import com.springboot.bookshelfapp.model.Book;
import com.springboot.bookshelfapp.repo.IBookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BookRepoIntegrationTest {

    @Autowired
    private IBookRepo repo;

    @Test
    public void whenSavingNewBook_thenSuccess() {
        Book newBook = new Book("title", "author", 2000);

        assertNotNull(repo.save(newBook));
    }

    @Test
    public void givenBookCreated_whenFindById_thenSuccess() {
        Book newBook = new Book("title", "author", 2000);
        repo.save(newBook);

        Optional<Book> retrievedBook = repo.findById(newBook.getId());
        assertThat(retrievedBook.get()).isEqualTo(newBook);
    }

    @Test
    public void givenBookCreated_whenFindByName_thenSuccess() {
        Book newBook = new Book("title", "author", 2000);
        repo.save(newBook);

        Optional<Book> retrievedBook = repo.findByAuthor(newBook.getAuthor());
        assertThat(retrievedBook.get()).isEqualTo(newBook);
    }

    @Test
    public void givenBookCreated_whenFindByYearBetween_thenSuccess() {
        Book newBook = new Book("title", "author", 2000);
        Book newBook2 = new Book("title", "author", 1980);
        Book newBook3 = new Book("title", "author", 1991);

        repo.save(newBook);
        repo.save(newBook2);
        repo.save(newBook3);

        List<Book> retrievedBooks = repo.findByYearPublishedBetween(1990, 2001);
        assertThat(retrievedBooks).contains(newBook, newBook3);
    }

    @Test
    public void givenBookCreated_whenFindByYearBetweenQuery_thenSuccess() {
        Book newBook = new Book("title", "author", 2000);
        Book newBook2 = new Book("title", "author", 1980);
        Book newBook3 = new Book("title", "author", 1991);

        repo.save(newBook);
        repo.save(newBook2);
        repo.save(newBook3);

        List<Book> retrievedBooks = repo.findByYearPublishedBetweenQuery(1990, 2001);
        assertThat(retrievedBooks).contains(newBook, newBook3);
    }
}
