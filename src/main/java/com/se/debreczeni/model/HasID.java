package com.se.debreczeni.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public abstract class HasID {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
