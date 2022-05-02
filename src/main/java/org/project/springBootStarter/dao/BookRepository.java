package org.project.springBootStarter.dao;

import org.project.springBootStarter.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    public List<Book> findByNameLike(String name);

}
