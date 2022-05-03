package org.project.springBootStarter.services;

import org.project.springBootStarter.entities.Book;
import org.project.springBootStarter.utils.NotFoundException;

import java.util.List;

public interface BookService {
    List<Book> getBook(String bookName) throws NotFoundException;

    List<Book> getAllBooks() throws NotFoundException;

    String saveBook(Book book);

    String updateBook(Long bookId, Book book) throws NotFoundException;

    String deleteBook(Long id) throws NotFoundException;
}
