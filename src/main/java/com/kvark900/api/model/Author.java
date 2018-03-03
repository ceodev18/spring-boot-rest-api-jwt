package com.kvark900.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Keno&Kemo on 17.12.2017..
 */
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;

//    @NotNull
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "authors")
    private Set<Book> books = new HashSet<>();


    //Constructors
    @Autowired
    public Author(String name, String surname, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.books = books;
    }
    @Autowired
    public Author(String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Author() {
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
