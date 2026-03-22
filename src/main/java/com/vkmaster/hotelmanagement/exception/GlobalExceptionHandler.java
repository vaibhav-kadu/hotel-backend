package com.vkmaster.hotelmanagement.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex){

        return new ResponseEntity<>(
                ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
