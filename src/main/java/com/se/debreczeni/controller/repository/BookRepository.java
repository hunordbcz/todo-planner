package com.se.debreczeni.controller.repository;

import com.se.debreczeni.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByTitle(String title);
}
