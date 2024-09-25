package com.greek.hefesto.ports.input.exception;


import com.greek.hefesto.config.exception.HefestoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for handling global exceptions in the application. It extends the
 * ResponseEntityExceptionHandler class, which provides default handling of exceptions.
 *
 * @author 2694883
 * @version v1
 * @since 2023-02-10
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(jakarta.validation.ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleConstraintViolationException(jakarta.validation.ConstraintViolationException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("errorCode", 400);
        Map<String, String> errors = new HashMap<>();
        e.getConstraintViolations().forEach(violation -> {
            String fieldName = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        });
        response.put("errorMessages", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


    @ExceptionHandler(HefestoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleConstraintViolationException(HefestoException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("errorCode", 400);
        Map<String, String> errors = new HashMap<>();
        errors.put("ip", e.getMessage());
        response.put("errorMessages", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }




}