package com.studentapp.restassured.project.studentinfo;

import com.studentapp.restassured.project.model.StudentPojo;
import com.studentapp.restassured.project.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StudentPatchTest extends TestBase {

    @Test
    public void patchSingleStudentRecord() {

        StudentPojo studentPojo = new StudentPojo();

        studentPojo.setFirstName("John" + Math.random());
        studentPojo.setLastName("Smith" + Math.random());

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .patch("/5");
                response.then().log().all().statusCode(200);
    }

    @Test

    public void patchMultipleStudentRecord() {

        for (int i = 11; i <= 20; i++) {

            StudentPojo studentPojo = new StudentPojo();

            studentPojo.setFirstName("John" + Math.random());
            studentPojo.setEmail("abc" + Math.random() + "@gmail.com");

            Response response = given()
                    .header("Content-Type", "application/json")
                    .when()
                    .body(studentPojo)
                    .patch(String.valueOf(i));
            response.then().log().all().statusCode(200);

        }
    }
}
