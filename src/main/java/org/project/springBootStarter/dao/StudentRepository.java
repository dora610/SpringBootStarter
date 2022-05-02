package org.project.springBootStarter.dao;

import org.project.springBootStarter.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("select s from Student s where s.firstName like %?1")
    List<Student> findWhoBinodIs(String firstname);

    List<Student> findByFirstName(String firstName);
}
