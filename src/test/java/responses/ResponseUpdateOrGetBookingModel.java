package responses;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseUpdateOrGetBookingModel {
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private ResponseUpdateOrGetBookingModel.Dates bookingdates;
    private String additionalneeds;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Dates {
        private String checkin;
        private String checkout;
    }
}
