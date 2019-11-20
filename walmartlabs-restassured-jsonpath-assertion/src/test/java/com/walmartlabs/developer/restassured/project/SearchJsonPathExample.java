package com.walmartlabs.developer.restassured.project;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPathExample {
    static final String APIKEY = "75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void init() {

        RestAssured.baseURI = "http://api.walmartlabs.com";
        RestAssured.basePath = "/v1";
    }

    // 1) Extract numItems
    @Test
    public void extractNumItems() {

        int numeItems = given()
                .queryParam("query", "ipod")
                .queryParam("apiKey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then().extract().path("numItems");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number of items are: " + numeItems);
        System.out.println("------------------End of Test---------------------------");

    }

    // 2) Extract query
    //Home work

    @Test
    public void extractQuery() {

        float salePrice = given()
                .queryParam("query", "ipod")
                .queryParam("apiKey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then().extract().path("items[5].salePrice");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The search query is: " + salePrice);
        System.out.println("------------------End of Test---------------------------");

    }

    // 3)Extract first productName by providing list index value
    @Test
    public void extractFirstProductName() {

        String productName = given()
                .queryParam("query", "ipod")
                .queryParam("apiKey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then().extract().path("items[0].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product name is: " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    // 4) Get the first imageEntities  for the first product
    //Home work

    @Test
    public void getFirdtImageEntitiesOfFirstProduct() {

        HashMap imageEntities = given()
                .queryParam("query", "ipod")
                .queryParam("apiKey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then().extract().path("items[0].imageEntities[0]");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The gift options under the first product are: " + imageEntities);
        System.out.println("------------------End of Test---------------------------");

    }

    // 5)Print the size of items
    //Home work

    @Test
    public void printSizeOfItems() {

        ArrayList<String>size = given()
                .queryParam("query", "ipod")
                .queryParam("apiKey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then().extract().path("items");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the items is: " + size);
        System.out.println("------------------End of Test---------------------------");
    }

    // 6) Get All the Names
    //Home work

    @Test
    public void getAllTheNames() {

        ArrayList<HashMap> name = given()
                .queryParam("query", "ipod")
                .queryParam("apiKey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then().extract().path("items.name");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the products are:: " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    // 7) Get the all the values for Name==Apple iPod touch 32GB
    @Test
    public void test007() {
        List<HashMap<String, Object>> values = given()
                .queryParam("query", "ipod")
                .queryParam("apiKey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then().extract().path("items.findAll{it.name=='Apple iPod touch 7th Generation 256GB - PRODUCT(RED) (New Model)'}");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for item name Apple iPod touch 7th Generation 256GB - PRODUCT(RED) (New Model) are: " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    // 8) Get the sale price for Name==Apple iPod touch 32GB
    @Test
    public void test008() {

        /*List<Float> salePrice = given()
                .queryParam("query", "ipod")
                .queryParam("apiKey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then().extract().path("items.findAll{it.name=='Apple iPod touch 32GB'}.salePrice");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The sale price is " + salePrice);
        System.out.println("------------------End of Test---------------------------");*/
    }

    // 9) Get the Names which have salePrice less than 150
    @Test
    public void test009() {

        List<String> names = given()
                .queryParam("query", "ipod")
                .queryParam("apiKey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then().extract().path("items.findAll{it.salePrice<150}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The items that are priced less than $150 are: " + names);
        System.out.println("------------------End of Test---------------------------");
    }

    // 10) Get the msrp of items that Start with name =Ref
    @Test
    public void test010() {

//        List<String> msrpValues = given()
//                .queryParam("query", "ipod")
//                .queryParam("apiKey", APIKEY)
//                .queryParam("format", "json")
//                .when()
//                .get("/search")
//                .then().extract().path("items.findAll{it.name==~/Ref.*/}.msrp");
//
//        System.out.println("------------------StartingTest---------------------------");
//        System.out.println("The msrp of items that start with Ref are: " + msrpValues);
//        System.out.println("------------------End of Test---------------------------");
    }

    // 10) Get the sale price of items that End with name =ed
    @Test
    public void test011() {

       /* List<String> saleprice = given()
                .queryParam("query", "ipod")
                .queryParam("apiKey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then().extract().path("items.findAll{it.name==~/.*ed/}.salePrice");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The msrp of items that end with ed are: " + saleprice);
        System.out.println("------------------End of Test---------------------------");*/
    }
}
