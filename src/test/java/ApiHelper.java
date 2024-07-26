package ru.netology.selenide;


import com.codeborne.selenide.Selenide;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://Localhost")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
    private ApiHelper(){
    }
    static DataGenerator.RegistrationDto sendRequest(DataGenerator.RegistrationDto user){
        Selenide.sleep(500);
        given()
                .spec(requestSpec)
                .body(user)
                .when().log().all()
                .post("/api/system/user")
                .then().log().all()
                .statusCode(200);
        return user;
    }
}
