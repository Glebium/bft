import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import requests.Booking;
import responses.ResponseCreateBookingModel;
import responses.ResponseUpdateOrGetBookingModel;

@Epic("Backend test")
public class BackendTest {
    @Test
    @Description("Проверка работы метода create")
    @Disabled
    public void testCreateBooking() {
        Booking booking = new Booking();
        // Выполнение запроса на создание записи
        ResponseCreateBookingModel response = booking.create(
                "Ivan",
                "Ivanov",
                23_000,
                true,
                "2025-01-12",
                "2025-12-21",
                "slippers"
        );
        // Проверка ответа сервера на запрос на создание записи
        Assertions.assertEquals("Ivan", response.getBooking().getFirstname());
        Assertions.assertEquals("Ivanov", response.getBooking().getLastname());
        Assertions.assertEquals(23_000, response.getBooking().getTotalprice());
        Assertions.assertEquals(true, response.getBooking().getDepositpaid());
        Assertions.assertEquals("2025-01-12", response.getBooking().getBookingdates().getCheckin());
        Assertions.assertEquals("2025-12-21", response.getBooking().getBookingdates().getCheckout());
        Assertions.assertEquals("slippers", response.getBooking().getAdditionalneeds());
    }

    @Test
    @Description("Проверка работы метода update")
    @Disabled
    public void testUpdateBooking() {
        Booking booking = new Booking();
        // Выполнение запроса на создание записи
        ResponseCreateBookingModel response = booking.create(
                "Alexander",
                "Volkov",
                15_000,
                false,
                "2025-01-01",
                "2026-01-18",
                "beer"
        );
        // Проверка ответа сервера на запрос на создание записи
        Assertions.assertEquals("Alexander", response.getBooking().getFirstname());
        Assertions.assertEquals("Volkov", response.getBooking().getLastname());
        Assertions.assertEquals(15_000, response.getBooking().getTotalprice());
        Assertions.assertEquals(false, response.getBooking().getDepositpaid());
        Assertions.assertEquals("2025-01-01", response.getBooking().getBookingdates().getCheckin());
        Assertions.assertEquals("2026-01-18", response.getBooking().getBookingdates().getCheckout());
        Assertions.assertEquals("beer", response.getBooking().getAdditionalneeds());
        // Выполнение запроса на обновление записи, изменяя только параметр lastname
        ResponseUpdateOrGetBookingModel response2 = booking.update(
                "Alexander",
                "Ovechkin",
                15_000,
                false,
                "2025-01-01",
                "2026-01-18",
                "beer"
        );
        // Проверка ответа сервера на запрос на обновление записи
        Assertions.assertEquals("Alexander", response2.getFirstname());
        Assertions.assertEquals("Ovechkin", response2.getLastname());
        Assertions.assertEquals(15_000, response2.getTotalprice());
        Assertions.assertEquals(false, response2.getDepositpaid());
        Assertions.assertEquals("2025-01-01", response2.getBookingdates().getCheckin());
        Assertions.assertEquals("2026-01-18", response2.getBookingdates().getCheckout());
        Assertions.assertEquals("beer", response2.getAdditionalneeds());
    }

    @Test
    @Description("Проверка работы метода get")
    @Disabled
    public void testGetBooking() {
        Booking booking = new Booking();
        // Выполнение запроса на создание записи
        ResponseCreateBookingModel response = booking.create(
                "Ivan",
                "Ivanov",
                23_000,
                true,
                "2025-01-12",
                "2025-12-21",
                "slippers"
        );
        // Проверка ответа сервера на запрос на создание записи
        Assertions.assertEquals("Ivan", response.getBooking().getFirstname());
        Assertions.assertEquals("Ivanov", response.getBooking().getLastname());
        Assertions.assertEquals(23_000, response.getBooking().getTotalprice());
        Assertions.assertEquals(true, response.getBooking().getDepositpaid());
        Assertions.assertEquals("2025-01-12", response.getBooking().getBookingdates().getCheckin());
        Assertions.assertEquals("2025-12-21", response.getBooking().getBookingdates().getCheckout());
        Assertions.assertEquals("slippers", response.getBooking().getAdditionalneeds());
        // Выполнение запроса на получение записи
        ResponseUpdateOrGetBookingModel response2 = booking.get(booking.bookingid);
        // Проверка ответа сервера на запрос на получение записи
        Assertions.assertEquals("Ivan", response2.getFirstname());
        Assertions.assertEquals("Ivanov", response2.getLastname());
        Assertions.assertEquals(23_000, response2.getTotalprice());
        Assertions.assertEquals(true, response2.getDepositpaid());
        Assertions.assertEquals("2025-01-12", response2.getBookingdates().getCheckin());
        Assertions.assertEquals("2025-12-21", response2.getBookingdates().getCheckout());
        Assertions.assertEquals("slippers", response2.getAdditionalneeds());
    }

    @Test
    @Description("Проверка работы метода delete")
    @Disabled
    public void testDeleteBooking() {
        Booking booking = new Booking();
        // Выполнение запроса на создание записи
        ResponseCreateBookingModel response = booking.create(
                "Ivan",
                "Ivanov",
                23_000,
                true,
                "2025-01-12",
                "2025-12-21",
                "slippers"
        );
        // Проверка ответа сервера на запрос на создание записи
        Assertions.assertEquals("Ivan", response.getBooking().getFirstname());
        Assertions.assertEquals("Ivanov", response.getBooking().getLastname());
        Assertions.assertEquals(23_000, response.getBooking().getTotalprice());
        Assertions.assertEquals(true, response.getBooking().getDepositpaid());
        Assertions.assertEquals("2025-01-12", response.getBooking().getBookingdates().getCheckin());
        Assertions.assertEquals("2025-12-21", response.getBooking().getBookingdates().getCheckout());
        Assertions.assertEquals("slippers", response.getBooking().getAdditionalneeds());
        // Выполнение запроса на удаление записи
        booking.delete(booking.bookingid);
    }

//    @Test
//    @Description("Проверка работы метода create при заполнении одного поля как NULL")
//    public void testCreate2Booking() {
//        Booking booking = new Booking();
//        // Выполнение запроса на создание записи
//        try {
//            ResponseCreateBookingModel response = booking.create(
//                    "Ivan",
//                    null,
//                    23_000,
//                    true,
//                    "2025-01-12",
//                    "2025-12-21",
//                    "slippers"
//            );
//        } catch (java.lang.AssertionError e) {
//
//        }
//    }
}
