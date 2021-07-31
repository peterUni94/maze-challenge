package com.etraveli.group.mazechallenge.exception;

public class ApplicationMazeException extends RuntimeException {

    public ApplicationMazeException(String message) {
        super(message);
    }

    public ApplicationMazeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationMazeException(Throwable cause) {
        super(cause);
    }
}
