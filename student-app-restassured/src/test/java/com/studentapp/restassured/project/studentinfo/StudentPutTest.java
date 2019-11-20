package com.studentapp.restassured.project.studentinfo;

import com.studentapp.restassured.project.model.StudentPojo;
import com.studentapp.restassured.project.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;


import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPutTest extends TestBase {
    @Test
    public void putSingleStudentRecord() {

        List<String> cources = new ArrayList<>();
        cources.add("Java");
        cources.add("C++");

        StudentPojo studentPojo = new StudentPojo();

        studentPojo.setFirstName("John" + Math.random());
        studentPojo.setLastName("Smith");
        studentPojo.setEmail("abc" + Math.random() + "@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCources(cources);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .put("/5");
        response.then().log().all().statusCode(200);
    }

    @Test

    public void putMultipleStudentRecord() {

        for (int i = 1; i <= 10; i++) {

            List<String> cources = new ArrayList<>();
            cources.add("Java");
            cources.add("C++");

            StudentPojo studentPojo = new StudentPojo();

            studentPojo.setFirstName("John" + Math.random());
            studentPojo.setLastName("Smith");
            studentPojo.setEmail("pqr" + Math.random() + "@gmail.com");
            studentPojo.setProgramme("Automation Testing");
            studentPojo.setCources(cources);

            Response response = given()
                    .header("Content-Type", "application/json")
                    .when()
                    .body(studentPojo)
                    .put(String.valueOf(i));
            response.then().log().all().statusCode(200);
        }
    }
}
