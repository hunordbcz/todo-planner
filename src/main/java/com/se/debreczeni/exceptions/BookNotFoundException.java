package com.se.debreczeni.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
        super("The book is not found.");
    }
}