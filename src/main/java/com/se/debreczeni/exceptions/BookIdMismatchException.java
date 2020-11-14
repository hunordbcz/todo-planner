package com.se.debreczeni.exceptions;

public class BookIdMismatchException extends RuntimeException {

    public BookIdMismatchException() {
        super("The Book and the ID is not matching");
    }
}