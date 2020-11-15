package com.se.debreczeni.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Book extends HasID{
    @Column(nullable = false, unique = true)
    private String title;

    @NotBlank(message = "Author is mandatory")
    private String author;
}
