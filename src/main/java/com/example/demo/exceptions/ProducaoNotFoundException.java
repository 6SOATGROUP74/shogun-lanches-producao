package com.example.demo.exceptions;

public class ProducaoNotFoundException extends RuntimeException {

    public ProducaoNotFoundException(final String message){
        super(message);
    };

    public ProducaoNotFoundException(final String message, final Throwable cause){
        super(message, cause);
    };
}
