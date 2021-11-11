package com.example.exercise1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MovieRestControllerNullException extends Exception{

    public MovieRestControllerNullException(String message) {
        super(message);
    }
}
