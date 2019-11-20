package com.studentapp.restassured.project.studentinfo;

import com.studentapp.restassured.project.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentGetTest extends TestBase {


    @Test
    public void getAllStudentInforrmation() {
        Response response = given()
//                        Response response = given().log().all()
                .when()
                .get("/list"); // Endpoint "/List"
        response.then().statusCode(200);
//                response.then().log().ifValidationFails().statusCode(201);

        System.out.println(response.prettyPrint());

//        or We can use below method

//        ValidatableResponse response1 = given()
//                .when()
//                .get("/list")
//                .then()
//                .statusCode(200);
    }

    @Test
    public void getSingleStudentInformation() {
        Response response = given()
                .when()
                .get("/1");
        System.out.println(response.prettyPrint());
    }

    @Test
    public void getAllStudentInfoWithParameter() {
        Response response = given()
                .param("programme", "Financial Analysis")
                .param("limit", 2)
                .when()
                .get("/list");
        System.out.println(response.prettyPrint());
        response.then().log().all().statusCode(200);
    }

    @Test
    public void getMultipleStudentInfo() {
        for (int i = 11; i<=20; i++) {
            Response response = given()
                    .when()
                    .get(String.valueOf(i));
            response.then().log().all().statusCode(200);
        }
    }

    @Test
    public void getMultipleStudentInfoByParam() {
        for (int i = 11; i <= 50; i++) {
            Response response = given()
                    .param("programme", "Financial Analysis")
                    .param("limit", 2)
                    .when()
                    .get(String.valueOf(i));
            System.out.println(response.prettyPrint());
            response.then().log().all().statusCode(200);
        }
    }
}
