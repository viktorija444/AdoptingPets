package com.example.springudomljavanjezivotinja.exception;

public class WrongIDException extends RuntimeException {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public WrongIDException(String message) {
        super(message);
        this.message = message;
    }


}
