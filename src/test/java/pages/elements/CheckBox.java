package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;


public class CheckBox extends Field {
    private final SelenideElement element;
    private final int waitSecond = 10;

    public CheckBox(SelenideElement element) {
        this.element = element;
    }

    public CheckBox click() {
        element.shouldBe(Condition.exist, Duration.ofSeconds(waitSecond)).click();
        return this;
    }

    public CheckBox checkIsSelected() {
        element.shouldBe(Condition.selected);
        return this;
    }

    @Step("Проверка цвета границы")
    public CheckBox checkBorderColor(Field.Color rgb) {
        element.shouldBe(Condition.cssValue("border-color", rgb.getValue()), Duration.ofSeconds(waitSecond));
        return this;
    }
}
