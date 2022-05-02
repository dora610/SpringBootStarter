package org.project.springBootStarter.services;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.project.springBootStarter.dao.BookRepository;
import org.project.springBootStarter.entities.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository repository;

    public List<Book> getBook(String bookName){
        return repository.findByNameLike(bookName);
    }

    public List<Book> getAllBooks(){
        List<Book> bookList = new ArrayList<>();
        repository.findAll().forEach(bookList::add);
        return bookList;
    }

    public String saveBook(Book book){
        Book savedBook = repository.save(book);
        log.info("saved book: {}", savedBook);
        return savedBook.getName();
    }

    public String updateBook(Long bookId, Book book) throws Exception {
        Book existingBook = repository.findById(bookId).orElseThrow(() -> new Exception("No such book exists"));
        repository.save(cretedNewBook(existingBook.getId(), book));
        return "Successfully updated";
    }

    public Book cretedNewBook(Long bookId, Book book){
        book.setId(bookId);
        return book;
    }
}
