package requests;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import responses.ResponseCreateBookingModel;


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
    public Response create(
            String firstname,
            String lastname,
            Integer totalprice,
            Boolean depositpaid,
            String checkin,
            String checkout,
            String additionalneeds
    ) {
        Response response = RestAssured
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
            .post("/booking");
        if (response.statusCode() == 200) {
            bookingid = response.as(ResponseCreateBookingModel.class).getBookingid();
        }
        return response;
    }

    @Step("Выполнение запроса на обновление записи")
    public Response update(
            String firstname,
            String lastname,
            Integer totalprice,
            Boolean depositpaid,
            String checkin,
            String checkout,
            String additionalneeds
    ) {
        Response response = RestAssured
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
                .put("/booking/" + bookingid);
        return response;
    }

    @Step("Выполнение запроса на получение записи")
    public Response get(Integer id) {
        Response response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .header("Accept", "application/json")
                .when()
                .get("/booking/" + id);
        return response;
    }

    @Step("Выполнение запроса на удаление записи")
    public Response delete(Integer id) {

        Response response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .header("Cookie", "token=" + token)
                .when()
                .delete("/booking/" + id);
        return response;
    }
}
