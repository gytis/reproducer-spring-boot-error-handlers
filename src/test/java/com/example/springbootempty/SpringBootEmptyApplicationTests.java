package com.example.springbootempty;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.ContentType.TEXT;
import static io.restassured.http.ContentType.XML;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootEmptyApplicationTests {

    @LocalServerPort
    private int port;

    @Before
    public void before() {
        RestAssured.baseURI = "http://localhost:" + port;
    }

    @Test
    public void shouldGetJsonError() {
        given().accept(JSON)
                .when().get("/json")
                .then()
                .statusCode(200)
                .contentType(JSON)
                .body(is("{\"message\":\"json\"}"));
    }

    @Test
    public void shouldGetJsonErrorWithoutAsking() {
        when().get("/json")
                .then()
                .statusCode(200)
                .contentType(JSON)
                .body(is("{\"message\":\"json\"}"));

    }

    @Test
    public void shouldGetXmlError() {
        given().accept(XML)
                .when().get("/xml")
                .then()
                .statusCode(200)
                .contentType(XML)
                .body(is("<Error><message>xml</message></Error>"));
    }

    @Test
    public void shouldOnlyAllowAskingForXmlError() {
        given().accept(JSON)
                .when().get("/xml")
                .then()
                .statusCode(406);
    }

    @Test
    public void shouldGetXmlErrorWithoutAsking() {
        when().get("/xml")
                .then()
                .statusCode(200)
                .contentType(XML)
                .body(is("<Error><message>xml</message></Error>"));
    }
}
