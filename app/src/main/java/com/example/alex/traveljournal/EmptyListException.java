package com.example.alex.traveljournal;

class EmptyListException extends RuntimeException {
    String message = "EmptyList";
    public EmptyListException(String message) {
        this.message = message;
    }

    public EmptyListException() {
    }
}
