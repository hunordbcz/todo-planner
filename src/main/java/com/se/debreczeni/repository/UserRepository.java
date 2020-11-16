package com.se.debreczeni.repository;

import com.se.debreczeni.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByEmail(String email);
    List<User> findByName(String name);
}