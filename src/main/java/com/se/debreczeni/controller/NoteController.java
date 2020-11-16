package com.se.debreczeni.controller;

import com.se.debreczeni.model.Note;
import com.se.debreczeni.model.User;
import com.se.debreczeni.repository.NoteRepository;
import com.se.debreczeni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/{id}")
    public String index(@PathVariable long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        model.addAttribute("notes", noteRepository.findByUser(user));
        return "notes/index";
    }

    @GetMapping("/{id}/add")
    public String showAddNoteForm(@PathVariable long id, Note note, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "notes/add";
    }

    @PostMapping("/{id}/add")
    public String addNote(@PathVariable long id, @Valid Note note, BindingResult result, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        note.setUser(user);

        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "notes/add";
        }

        noteRepository.save(note);
        return "redirect:/notes/" + id;
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));

        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid note Id:" + id));

        model.addAttribute("user", note.getUser());
        model.addAttribute("note", note);
        return "notes/update";
    }

    @PostMapping("/update/{id}")
    public String updateNote(@PathVariable long id, @Valid Note note, BindingResult result) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userId));
//        note.setUser(user);

        if (result.hasErrors()) {
            note.setId(id);
            note.setUser(note.getUser());
            return "notes/update";
        }

        noteRepository.save(note);
        return "redirect:/notes/" + note.getUser().getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") long id) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid note Id:" + id));

//        if(!note.getUser().equals(user)){
//            throw new IllegalArgumentException("The given user is not the owner of the note:");
//        }

        noteRepository.delete(note);
        return "redirect:/notes/" + note.getUser().getId();
    }
}
