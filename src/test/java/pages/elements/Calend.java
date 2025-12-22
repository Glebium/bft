package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;


public class Calend extends Field {
    private final SelenideElement element;
    private final String dayPickerFormatString;
    private final SelenideElement monthSelect;
    private final SelenideElement yearSelect;
    private final int waitSecond = 10;

    public Calend(
            SelenideElement element,
            String dayPickerFormatString,
            SelenideElement monthSelect,
            SelenideElement yearSelect) {
        this.element = element;
        this.dayPickerFormatString = dayPickerFormatString;
        this.monthSelect = monthSelect;
        this.yearSelect = yearSelect;
    }

    public Calend click() {
        element.click();
        return this;
    }

    @Step("Установка даты: день, месяц и год")
    public Calend set(Integer day, String month, String year) {
        element.shouldBe(Condition.visible).click();
        SelenideElement datePopup = $(byClassName("react-datepicker-popper"));
        datePopup.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond));
        monthSelect.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond)).selectOption(month);
        yearSelect.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond)).selectOption(year);
        $(byXpath(String.format(dayPickerFormatString, day))).shouldBe(Condition.visible, Duration.ofSeconds(waitSecond)).click();
        return this;
    }

    @Step("Проверка цвета границы")
    public Calend checkBorderColor(Field.Color rgb) {
        element.shouldBe(Condition.cssValue("border-color", rgb.getValue()), Duration.ofSeconds(waitSecond));
        return this;
    }
}