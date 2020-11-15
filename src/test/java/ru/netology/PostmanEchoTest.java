package ru.netology;

import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    void shouldReturnDemoAccounts() {

        given()
                .baseUri("https://postman-echo.com")
                .body("I hope, its gonna be work")

// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("I hope, its gonna be work"))
                .body("headers.content-length", equalTo("25"));

    }
}
