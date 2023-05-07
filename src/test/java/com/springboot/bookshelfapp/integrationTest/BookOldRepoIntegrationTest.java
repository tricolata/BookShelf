package com.springboot.bookshelfapp.integrationTest;

import com.springboot.bookshelfapp.model.Book_old;
import com.springboot.bookshelfapp.repo.IBookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BookOldRepoIntegrationTest {

    @Autowired
    private IBookRepo repo;

    @Test
    public void whenSavingNewBook_thenSuccess() {
        Book_old newBook = new Book_old("title", "author", 2000);
        assertNotNull(repo.save(newBook));
    }

    @Test
    public void givenBookCreated_whenFindById_thenSuccess() {
        Book_old newBook = new Book_old("title", "author", 2000);
        repo.save(newBook);

        Optional<Book_old> retrievedBook = repo.findById(newBook.getId());
        assertThat(retrievedBook.get()).isEqualTo(newBook);
    }

    @Test
    public void givenBookCreated_whenFindByName_thenSuccess() {
        Book_old newBook = new Book_old("title", "author", 2000);
        repo.save(newBook);

        Optional<Book_old> retrievedBook = repo.findByAuthor(newBook.getAuthor());
        assertThat(retrievedBook.get()).isEqualTo(newBook);
    }

    @Test
    public void givenBookCreated_whenFindByYearBetween_thenSuccess() {
        Book_old newBook = new Book_old("title", "author", 2000);
        Book_old newBook2 = new Book_old("title", "author", 1980);
        Book_old newBook3 = new Book_old("title", "author", 1991);

        repo.save(newBook);
        repo.save(newBook2);
        repo.save(newBook3);

        List<Book_old> retrievedBooks = repo.findByYearPublishedBetween(1990, 2001);
        assertThat(retrievedBooks).contains(newBook, newBook3);
    }

    @Test
    public void givenBookCreated_whenFindByYearBetweenQuery_thenSuccess() {
        Book_old newBook = new Book_old("title", "author", 2000);
        Book_old newBook2 = new Book_old("title", "author", 1980);
        Book_old newBook3 = new Book_old("title", "author", 1991);

        repo.save(newBook);
        repo.save(newBook2);
        repo.save(newBook3);

        List<Book_old> retrievedBooks = repo.findByYearPublishedBetweenQuery(1990, 2001);
        assertThat(retrievedBooks).contains(newBook, newBook3);
    }
}
