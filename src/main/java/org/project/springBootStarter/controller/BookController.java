package org.project.springBootStarter.controller;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.project.springBootStarter.entities.Book;
import org.project.springBootStarter.services.BookService;
import org.project.springBootStarter.utils.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/find")
    public ResponseEntity<List<Book>> getBook(@RequestParam(value = "name") String bookName) throws InvalidInputException {
        if(bookName==null || bookName.isBlank()){
            throw new InvalidInputException(String.format("Invalid input provided for book name: %s", bookName));
        }
        return ResponseEntity.of(Optional.of(service.getBook(bookName)));
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBook() throws NotFoundException {
        List<Book> books = service.getAllBooks();
        if(books.size() == 0){
            throw new NotFoundException("No book available");
        }
        return ResponseEntity.of(Optional.of(books));
    }
    @PostMapping("/")
    public ResponseEntity<String> saveBook(@RequestBody Book book){
        String template = "Successfully saved book: %s";
        return ResponseEntity.of(Optional.of(String.format(template, service.saveBook(book))));
    }

    @PutMapping("/")
    public ResponseEntity<String> updateBook(@RequestParam(value = "id") Long bookId, @RequestBody Book book) throws Exception {
        return ResponseEntity.of(Optional.of(service.updateBook(bookId, book)));
    }
}
