package me.jeonguk.examples.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    Long id;

    @Getter
    String name;

    @Embedded
    Email userEmail;

    public UserEntity(String name) {
        this.name = name;
        this.userEmail = new Email();
    }

    public String getFullEmail() {
        return this.userEmail.isEmpty() ? "" : this.userEmail.getFullEmail();
    }

    public void updateEmail(Email email) {
        this.userEmail = email;
    }

}
