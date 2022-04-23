package de.mongodb.springmongodbtutorial.models;

public record Address(
    String country,
    String postCode,
    String city
) {

}
