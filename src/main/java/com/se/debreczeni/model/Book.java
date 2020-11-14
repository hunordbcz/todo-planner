package com.se.debreczeni.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Book extends HasID{
    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String author;
}
