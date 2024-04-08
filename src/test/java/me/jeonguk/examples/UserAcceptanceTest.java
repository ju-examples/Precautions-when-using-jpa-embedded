package me.jeonguk.examples;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import me.jeonguk.examples.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserAcceptanceTest {

    @LocalServerPort int port;
    @Autowired UserRepository userRepository;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        userRepository.deleteAll();
    }

    private void 사용자_생성됨(String name) {
        ExtractableResponse<Response> response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).log().all()
                .when()
                .body("""
                        {
                            "name": "%s"
                        }
                        """.formatted(name))
                .post("/users")
                .then().log().all().extract();

        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    @DisplayName("사용자 조회")
    void getUser() {
        // given
        사용자_생성됨("jeonguk");

        // when
        ExtractableResponse<Response> response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).log().all()
                .when()
                .get("/users/1")
                .then().log().all().extract();

        // then
        Assertions.assertEquals(200, response.statusCode());
    }
}