package com.uc.application;

import io.restassured.RestAssured;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Optional;


public class RestAssuredExtension implements BeforeAllCallback, AfterAllCallback {

    private static final int SERVER_PORT = 8088;
    private static final String BASE_URL = RestAssured.DEFAULT_URI + "/api/v1";


    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {

        RestAssured.port = SERVER_PORT;
        RestAssured.baseURI = BASE_URL;
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        RestAssured.reset();
    }

    private Optional<String> getSystemProperty(String propertyName) {
        return Optional.ofNullable(System.getProperty(propertyName));
    }

}
