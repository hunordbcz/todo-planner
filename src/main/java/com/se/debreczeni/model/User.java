package com.se.debreczeni.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
public class User extends HasID{

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    @OneToMany
    private List<Note> notes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}