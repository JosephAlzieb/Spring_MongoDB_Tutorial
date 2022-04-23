package de.mongodb.springmongodbtutorial;

import de.mongodb.springmongodbtutorial.models.Address;
import de.mongodb.springmongodbtutorial.models.Gender;
import de.mongodb.springmongodbtutorial.models.Student;
import de.mongodb.springmongodbtutorial.repositories.StudentRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication
public class SpringMongoDbTutorialApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringMongoDbTutorialApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner (StudentRepository repository, MongoTemplate mongoTemplate){
    return args -> {
      Address address = new Address("Germany", "GD12", "Dusseldorf");
      String email = "joe@web.de";
      Student student = new Student(
          "Joseph",
          "Alzieb",
          email,
          Gender.MALE,
          address,
          List.of("Math", "Bio"),
          LocalDateTime.now()
      );

//      usingMongoTemplateAndQuery(repository, mongoTemplate, email, student);


    };
  }


  private void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, String email,
      Student student) {
    Query query = new Query();
    query.addCriteria(Criteria.where("email").is(email));

    List<Student> students = mongoTemplate.find(query, Student.class);

    if(students.size() >= 1){
      throw new IllegalStateException("found many students with email " + email);
    }

    if(students.isEmpty()){
      repository.insert(student);
      System.out.println("Inserting student " + student);
    }
    else {
      System.out.println(student + " already exists");
    }
  }
}
