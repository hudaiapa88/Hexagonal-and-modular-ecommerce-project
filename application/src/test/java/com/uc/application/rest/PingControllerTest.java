package com.uc.application.rest;

import com.uc.application.IT;
import com.uc.application.ResponseSpec;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Tag("Ping")
@IT
public class PingControllerTest  {
    @Nested
    class Ping{
       @Test
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
