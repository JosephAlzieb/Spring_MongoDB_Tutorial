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

@SpringBootApplication
public class SpringMongoDbTutorialApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringMongoDbTutorialApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner (StudentRepository repository){
    return args -> {
      Address address = new Address("Germany", "GD12", "Dusseldorf");
      Student student = new Student(
          "Joseph",
          "Alzieb",
          "joe@web.de",
          Gender.MALE,
          address,
          List.of("Math", "Bio"),
          LocalDateTime.now()
      );

      repository.insert(student);
    };
  }
}
