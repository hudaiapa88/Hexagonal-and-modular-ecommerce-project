package com.uc.application.rest;

import com.uc.application.ApplicationTests;
import com.uc.application.ResponseSpec;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;

import static io.restassured.RestAssured.given;

@Tag("Ping")
public class PingControllerTest extends ApplicationTests {
    @Nested
    class Ping{
        void testPing(){
            String response=given()
                    .contentType(ContentType.JSON).when().get(path()).then().spec(ResponseSpec.isOkResponse())
                    .extract().body().asString();
        }
        private String path() {
            return String.format("/ping");
        }
    }
}
