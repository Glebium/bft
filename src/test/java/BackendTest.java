import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import requests.Booking;
import responses.ResponseCreateBookingModel;
import responses.ResponseUpdateOrGetBookingModel;

@Epic("Backend test")
public class BackendTest {
    @Test
    @Description("Проверка работы метода create")
    public void testCreateBooking() {
        Booking booking = new Booking();
        // Выполнение запроса на создание записи
        Response response = booking.create(
                "Ivan",
                "Ivanov",
                23_000,
                true,
                "2025-01-12",
                "2025-12-21",
                "slippers"
        );
        // Проверка статус кода ответа
        Assertions.assertEquals(200, response.getStatusCode());
        // Проверка ответа сервера на запрос на создание записи
        ResponseCreateBookingModel responseModel = response.as(ResponseCreateBookingModel.class);
        Assertions.assertEquals("Ivan", responseModel.getBooking().getFirstname());
        Assertions.assertEquals("Ivanov", responseModel.getBooking().getLastname());
        Assertions.assertEquals(23_000, responseModel.getBooking().getTotalprice());
        Assertions.assertEquals(true, responseModel.getBooking().getDepositpaid());
        Assertions.assertEquals("2025-01-12", responseModel.getBooking().getBookingdates().getCheckin());
        Assertions.assertEquals("2025-12-21", responseModel.getBooking().getBookingdates().getCheckout());
        Assertions.assertEquals("slippers", responseModel.getBooking().getAdditionalneeds());
    }

    @Test
    @Description("Проверка работы метода update")
    public void testUpdateBooking() {
        Booking booking = new Booking();
        // Выполнение запроса на создание записи
        Response response = booking.create(
                "Alexander",
                "Volkov",
                15_000,
                false,
                "2025-01-01",
                "2026-01-18",
                "beer"
        );
        // Проверка статус кода ответа
        Assertions.assertEquals(200, response.getStatusCode());
        // Проверка ответа сервера на запрос на создание записи
        ResponseCreateBookingModel responseModel = response.as(ResponseCreateBookingModel.class);
        Assertions.assertEquals("Alexander", responseModel.getBooking().getFirstname());
        Assertions.assertEquals("Volkov", responseModel.getBooking().getLastname());
        Assertions.assertEquals(15_000, responseModel.getBooking().getTotalprice());
        Assertions.assertEquals(false, responseModel.getBooking().getDepositpaid());
        Assertions.assertEquals("2025-01-01", responseModel.getBooking().getBookingdates().getCheckin());
        Assertions.assertEquals("2026-01-18", responseModel.getBooking().getBookingdates().getCheckout());
        Assertions.assertEquals("beer", responseModel.getBooking().getAdditionalneeds());
        // Выполнение запроса на обновление записи, изменяя только параметр lastname
        Response response2 = booking.update(
                "Alexander",
                "Ovechkin",
                15_000,
                false,
                "2025-01-01",
                "2026-01-18",
                "beer"
        );
        // Проверка статус кода ответа
        Assertions.assertEquals(200, response2.getStatusCode());
        // Проверка ответа сервера на запрос на обновление записи
        ResponseUpdateOrGetBookingModel responseModel2 = response2.as(ResponseUpdateOrGetBookingModel.class);
        Assertions.assertEquals("Alexander", responseModel2.getFirstname());
        Assertions.assertEquals("Ovechkin", responseModel2.getLastname());
        Assertions.assertEquals(15_000, responseModel2.getTotalprice());
        Assertions.assertEquals(false, responseModel2.getDepositpaid());
        Assertions.assertEquals("2025-01-01", responseModel2.getBookingdates().getCheckin());
        Assertions.assertEquals("2026-01-18", responseModel2.getBookingdates().getCheckout());
        Assertions.assertEquals("beer", responseModel2.getAdditionalneeds());
    }

    @Test
    @Description("Проверка работы метода get")
    public void testGetBooking() {
        Booking booking = new Booking();
        // Выполнение запроса на создание записи
        Response response = booking.create(
                "Ivan",
                "Ivanov",
                23_000,
                true,
                "2025-01-12",
                "2025-12-21",
                "slippers"
        );
        // Проверка статус кода ответа
        Assertions.assertEquals(200, response.getStatusCode());
        // Проверка ответа сервера на запрос на создание записи
        ResponseCreateBookingModel responseModel = response.as(ResponseCreateBookingModel.class);
        Assertions.assertEquals("Ivan", responseModel.getBooking().getFirstname());
        Assertions.assertEquals("Ivanov", responseModel.getBooking().getLastname());
        Assertions.assertEquals(23_000, responseModel.getBooking().getTotalprice());
        Assertions.assertEquals(true, responseModel.getBooking().getDepositpaid());
        Assertions.assertEquals("2025-01-12", responseModel.getBooking().getBookingdates().getCheckin());
        Assertions.assertEquals("2025-12-21", responseModel.getBooking().getBookingdates().getCheckout());
        Assertions.assertEquals("slippers", responseModel.getBooking().getAdditionalneeds());
        // Выполнение запроса на получение записи
        Response response2 = booking.get(booking.bookingid);
        // Проверка статус кода ответа
        Assertions.assertEquals(200, response2.getStatusCode());
        // Проверка ответа сервера на запрос на получение записи
        ResponseUpdateOrGetBookingModel responseModel2 = response2.as(ResponseUpdateOrGetBookingModel.class);
        Assertions.assertEquals("Ivan", responseModel2.getFirstname());
        Assertions.assertEquals("Ivanov", responseModel2.getLastname());
        Assertions.assertEquals(23_000, responseModel2.getTotalprice());
        Assertions.assertEquals(true, responseModel2.getDepositpaid());
        Assertions.assertEquals("2025-01-12", responseModel2.getBookingdates().getCheckin());
        Assertions.assertEquals("2025-12-21", responseModel2.getBookingdates().getCheckout());
        Assertions.assertEquals("slippers", responseModel2.getAdditionalneeds());
    }

    @Test
    @Description("Проверка работы метода delete")
    public void testDeleteBooking() {
        Booking booking = new Booking();
        // Выполнение запроса на создание записи
        Response response = booking.create(
                "Ivan",
                "Ivanov",
                23_000,
                true,
                "2025-01-12",
                "2025-12-21",
                "slippers"
        );
        // Проверка статус кода ответа
        Assertions.assertEquals(200, response.getStatusCode());
        // Проверка ответа сервера на запрос на создание записи
        ResponseCreateBookingModel responseModel = response.as(ResponseCreateBookingModel.class);
        Assertions.assertEquals("Ivan", responseModel.getBooking().getFirstname());
        Assertions.assertEquals("Ivanov", responseModel.getBooking().getLastname());
        Assertions.assertEquals(23_000, responseModel.getBooking().getTotalprice());
        Assertions.assertEquals(true, responseModel.getBooking().getDepositpaid());
        Assertions.assertEquals("2025-01-12", responseModel.getBooking().getBookingdates().getCheckin());
        Assertions.assertEquals("2025-12-21", responseModel.getBooking().getBookingdates().getCheckout());
        Assertions.assertEquals("slippers", responseModel.getBooking().getAdditionalneeds());
        // Выполнение запроса на удаление записи
        Response response2 = booking.delete(booking.bookingid);
        // Проверка статус кода ответа
        Assertions.assertEquals(201, response2.getStatusCode());
    }

    @Test
    @Description("Проверка работы метода create при заполнении одного поля как NULL")
    public void testCreateBookingWithNull() {
        Booking booking = new Booking();
        // Выполнение запроса на создание записи
        Response response = booking.create(
                "Ivan",
                null,
                23_000,
                true,
                "2025-01-12",
                "2025-12-21",
                "slippers"
        );
        Assertions.assertEquals(500, response.getStatusCode());
    }

    @Test
    @Description("Проверка работы метода delete при указании id несуществующей записи")
    public void testDeleteBookingNotExists() {
        Booking booking = new Booking();
        // Выполнение запроса на удаление несуществующей записи
        Response response = booking.delete(999999001);
        Assertions.assertEquals(405, response.getStatusCode());
    }
}
