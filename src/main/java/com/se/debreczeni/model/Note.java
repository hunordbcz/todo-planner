package com.se.debreczeni.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Note extends HasID{

    @NotBlank
    private String content;

    @OneToOne
    private User user;
}
