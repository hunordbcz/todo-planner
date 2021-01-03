package com.se.debreczeni.repository;

import com.se.debreczeni.model.Note;
import com.se.debreczeni.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    List<Note> findByUser(User user);
}