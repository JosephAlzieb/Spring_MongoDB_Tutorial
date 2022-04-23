package de.mongodb.springmongodbtutorial.repositories;

import de.mongodb.springmongodbtutorial.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,String> {

}
