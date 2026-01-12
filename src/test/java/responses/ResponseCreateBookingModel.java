package responses;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCreateBookingModel {
    private Integer bookingid;
    private ResponseCreateBookingModel.Booking booking;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Booking {
        private String firstname;
        private String lastname;
        private Integer totalprice;
        private Boolean depositpaid;
        private ResponseCreateBookingModel.Dates bookingdates;
        private String additionalneeds;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Dates {
        private String checkin;
        private String checkout;
    }
}
