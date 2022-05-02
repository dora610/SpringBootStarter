package org.project.springBootStarter;

import org.project.springBootStarter.dao.StudentRepository;
import org.project.springBootStarter.entities.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootStarterApplication {

	// set-up logger
	private static final Logger log = LoggerFactory.getLogger(SpringBootStarterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarterApplication.class, args);
	}

	// create commandRunner bean to instantiate jpa ops
	/*@Bean
	public CommandLineRunner demo(StudentRepository repository){
		return (args -> {
			// save few demo students
//			repository.save(new Student("John","Doe"));
//			repository.save(new Student("Binod","Jam"));
//			repository.save(new Student("Stonk","Smith"));
//			repository.save(new Student("Sams","Saik"));

			List<Student> li = new ArrayList<>();
			li.add(new Student("John","Doe"));
			li.add(new Student("Binod","Jam"));
			li.add(new Student("Stonk","Smith"));
			li.add(new Student("Sams","Saik"));
			repository.saveAll(li);

			// fetch all stydents
			log.info("Students found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(x -> log.info("Student: {}", x.toString()));
			log.info("");

			// fetch indivisual student
			repository.findById(3L).ifPresent(x -> log.info("Student found with findById(1L): {}", x));
			log.info("");

			// fetch by first name
			repository.findByFirstName("Sams").forEach(x -> log.info("Student with first name Sams: {}", x.toString()));

			repository.findWhoBinodIs("Binod").forEach(x -> log.info("Found Binod: {}", x.toString()));
		});
	}*/
}
