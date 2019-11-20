package com.studentapp.restassured.project.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {

    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/student";
    }
}