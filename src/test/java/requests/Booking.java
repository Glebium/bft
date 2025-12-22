package requests;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import responses.ResponseCreateBookingModel;
import responses.ResponseUpdateOrGetBookingModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
class BookingModel {
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private Dates bookingdates;
    private String additionalneeds;

    @Data
    @AllArgsConstructor
    public static class Dates {
        String checkin;
        String checkout;
    }
}


public class Booking {
    private String token;
    public Integer bookingid;

    public Booking() {
        this.token = auth();
    }

    @Step("Выполнение запроса на авторизацию")
    private String auth() {
        Response response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body("{\"username\": \"admin\", \"password\": \"password123\"}")
                .when().post("/auth").then().statusCode(200)
                .extract().response();

        token = response.path("token");
        return token;
    }

    @Step("Выполнение запроса на создание записи")
    public ResponseCreateBookingModel create(
            String firstname,
            String lastname,
            Integer totalprice,
            Boolean depositpaid,
            String checkin,
            String checkout,
            String additionalneeds
    ) {
        ResponseCreateBookingModel response = RestAssured
            .given()
            .baseUri("https://restful-booker.herokuapp.com")
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .body(new BookingModel(
                    firstname,
                    lastname,
                    totalprice,
                    depositpaid,
                    new BookingModel.Dates(checkin, checkout),
                    additionalneeds)
            )
            .when()
            .post("/booking")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .extract().body().as(ResponseCreateBookingModel.class);

        bookingid = response.getBookingid();
        return response;
    }

    @Step("Выполнение запроса на обновление записи")
    public ResponseUpdateOrGetBookingModel update(
            String firstname,
            String lastname,
            Integer totalprice,
            Boolean depositpaid,
            String checkin,
            String checkout,
            String additionalneeds
    ) {
        ResponseUpdateOrGetBookingModel response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(new BookingModel(
                        firstname,
                        lastname,
                        totalprice,
                        depositpaid,
                        new BookingModel.Dates(checkin, checkout),
                        additionalneeds)
                )
                .when()
                .put("/booking/" + bookingid)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().body().as(ResponseUpdateOrGetBookingModel.class);
        return response;
    }

    @Step("Выполнение запроса на получение записи")
    public ResponseUpdateOrGetBookingModel get(Integer id) {
        ResponseUpdateOrGetBookingModel response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .header("Accept", "application/json")
                .when()
                .get("/booking/" + id)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().body().as(ResponseUpdateOrGetBookingModel.class);
        return response;
    }

    @Step("Выполнение запроса на удаление записи")
    public ValidatableResponse delete(Integer id) {
        ValidatableResponse response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .header("Cookie", "token=" + token)
                .when()
                .delete("/booking/" + id)
                .then()
                .statusCode(201);
        return response;
    }
}
