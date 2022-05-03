package org.project.springBootStarter.dao;

import org.project.springBootStarter.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query(value = "select b from Book b where b.name like %?1")
    List<Book> findByNameLike(String name);

}
