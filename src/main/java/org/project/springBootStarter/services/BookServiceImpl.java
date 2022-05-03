package org.project.springBootStarter.services;

import org.project.springBootStarter.dao.BookRepository;
import org.project.springBootStarter.entities.Book;
import org.project.springBootStarter.utils.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> getBook(String bookName) throws NotFoundException {
        List<Book> books = repository.findByNameLike(bookName);
        if (books.isEmpty()) {
            throw new NotFoundException("No such book found");
        }
        return books;
    }

    @Override
    public List<Book> getAllBooks() throws NotFoundException {
        List<Book> bookList = new ArrayList<>();
        repository.findAll().forEach(bookList::add);
        if (bookList.isEmpty()) {
            throw new NotFoundException("No such book found");
        }
        return bookList;
    }

    @Override
    public String saveBook(Book book) {
        Book savedBook = repository.save(book);
        log.info("saved book: {}", savedBook);
        return savedBook.getName();
    }

    @Override
    public String updateBook(Long bookId, Book book) throws NotFoundException {
        Book existingBook = repository.findById(bookId).orElseThrow(() -> new NotFoundException("No such book exists"));
        book.setId(existingBook.getId());
        repository.save(book);
        return "Successfully updated";
    }

    @Override
    public String deleteBook(Long id) throws NotFoundException {
        repository.findById(id).orElseThrow(() -> new NotFoundException("No such book exists"));
        repository.deleteById(id);
        return "Successfully deleted book";
    }
}
