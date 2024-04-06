package me.jeonguk.examples.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Embedded
    Email userEmail;

    public User(String name) {
        this.name = name;
        this.userEmail = new Email();
    }

    public void updateEmail(Email email) {
        this.userEmail = email;
    }

}
