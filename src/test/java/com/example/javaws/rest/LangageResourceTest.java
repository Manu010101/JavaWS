package com.example.javaws.rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LangageResourceTest {

    public String baseUrl = "http://localhost:8081/JavaWS_war_exploded/api/langages";

    @Test
    void getLangage() throws IOException {

        Response response = RestAssured.get(this.baseUrl + "/6");

        assertEquals(
                200,
                response.statusCode()
        );

    }

    @Test
    void createLangage() throws IOException {

        JSONObject request = new JSONObject();
        request.put("nom", "nom_test");
        request.put("caracteristiques", "caracteristiques_test");

        System.out.println(request);
        System.out.println(request.toString());

        given().
                body(request.toJSONString()).
                when().
                post(this.baseUrl).
                then().statusCode(201 );
    }

    @Test
    void deleteLangage() {

    }
}