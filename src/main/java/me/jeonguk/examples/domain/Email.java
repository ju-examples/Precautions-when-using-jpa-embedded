package me.jeonguk.examples.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Email {

    String emailId;

    String emailDomain;

    public static Email of(String fullEmail) {
        String[] emailParts = fullEmail.split("@");
        return new Email(emailParts[0], emailParts[1]);
    }

}
