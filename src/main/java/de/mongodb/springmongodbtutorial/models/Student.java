package de.mongodb.springmongodbtutorial.models;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Student {

  @Id
  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private Gender gender;
  private Address address;
  private List<String> favouriteSubjects;
  private LocalDateTime created;

  public Student(
      String firstName,
      String lastName,
      String email,
      Gender gender,
      Address address,
      List<String> favouriteSubjects,
      LocalDateTime created) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
    this.address = address;
    this.favouriteSubjects = favouriteSubjects;
    this.created = created;
  }
}