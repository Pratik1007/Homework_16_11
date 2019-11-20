package com.studentapp.restassured.project.studentinfo;

import com.studentapp.restassured.project.model.StudentPojo;
import com.studentapp.restassured.project.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPostTest extends TestBase {


    @Test
    public void createNewStudent() {
        List<String> cources = new ArrayList<>();
        cources.add("Java");
        cources.add("C++");

        StudentPojo studentPojo = new StudentPojo();

        studentPojo.setFirstName("John");
        studentPojo.setLastName("Smith");
        studentPojo.setEmail("jsgtgjyt@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCources(cources);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().log().all().statusCode(201);
    }

    @Test
    public void createNewStudentRecord() {

        for(int i = 1; i<=10; i++) {
            List<String> cources = new ArrayList<>();
            cources.add("Java");
            cources.add("C++");

            StudentPojo studentPojo = new StudentPojo();
            studentPojo.setFirstName("John" + Math.random());
            studentPojo.setLastName("Smith");
            studentPojo.setEmail("abcd" + Math.random() + "@gmail.com");
            studentPojo.setProgramme("Automation Testing");
            studentPojo.setCources(cources);

            Response response = given()
                    .header("Content-Type", "application/json")
                    .when()
                    .body(studentPojo)
                    .post();
            response.then().log().all().statusCode(201);
        }
    }
}
