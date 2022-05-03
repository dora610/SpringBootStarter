package org.project.springBootStarter.utils;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.project.springBootStarter.services.BookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @ExceptionHandler(value = {InvalidInputException.class})
    public ResponseEntity<Object> InvalidInputExceptionHandler(InvalidInputException e) {
        log.error("Invalid Input Exception occurred: {}", e.getCause());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> notFoundExceptionHandler(NotFoundException e) {
        log.error("Not found error: {}", e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception e){
        log.error("Error occurred: ", e.getCause());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
