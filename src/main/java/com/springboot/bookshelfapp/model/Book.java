package com.springboot.bookshelfapp.model;

import java.util.List;

public class Book {

    private Long id;
    private String title;
    private String author;
    private Integer yearPublished;
    private List<String> genres;

    public Book(String title, String author, Integer yearPublished, List<String> genres) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genres = genres;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }
}
