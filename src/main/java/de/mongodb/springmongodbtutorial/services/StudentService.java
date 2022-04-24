package de.mongodb.springmongodbtutorial.services;

import de.mongodb.springmongodbtutorial.models.Student;
import de.mongodb.springmongodbtutorial.repositories.StudentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private StudentRepository repo;

  public StudentService(StudentRepository repo) {
    this.repo = repo;
  }

  public List<Student> getStudents() {
    return repo.findAll();
  }
}
