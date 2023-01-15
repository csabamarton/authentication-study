package com.csmarton.auth.controller;

import com.csmarton.auth.controller.error.ErrorResponse;
import com.csmarton.auth.validation.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsExceptions(
            Exception e
    ) {
        HttpStatus status = HttpStatus.BAD_REQUEST; // 400

        return new ResponseEntity<>(
                new ErrorResponse(
                        status,
                        e.getMessage()
                ),
                status
        );
    }
}