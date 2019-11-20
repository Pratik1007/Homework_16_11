package com.studentapp.restassured.project.studentinfo;

import com.studentapp.restassured.project.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class StudentDeleteTest extends TestBase {

    @Test
    public void deleteSingleStudentRecord(){
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/5");
        response.then().log().all().statusCode(204);
    }

    @Test
    public void deleteMultipleStudentRecord(){
        for(int i = 1; i <=10; i++){
            Response response = given()
                    .header("Content-Type", "application/json")
                    .when()
                    .delete(String.valueOf(i));
            response.then().log().all().statusCode(204);

        }
    }
}
