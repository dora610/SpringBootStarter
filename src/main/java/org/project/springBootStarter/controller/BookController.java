package org.project.springBootStarter.controller;

import org.project.springBootStarter.entities.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/book")
public class BookController {
    @GetMapping("/")
    public ResponseEntity<Book> getBook(){
        return null;
    }
}
