package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;


public class RadioButton extends Field {
    private final SelenideElement element;
    private final int waitSecond = 10;

    public RadioButton(SelenideElement element) {
        this.element=element;
    }

    public RadioButton checkVisability() {
        element.shouldBe(Condition.visible,Duration.ofSeconds(waitSecond));
        return this;
    }

    public RadioButton select() {
        element.scrollIntoView(true);
        element.shouldBe(Condition.exist, Duration.ofSeconds(waitSecond)).click();
        return this;
    }

    public RadioButton checkBorderColor(Field.Color rgb) {
        element.shouldBe(Condition.cssValue("border-color", rgb.getValue()), Duration.ofSeconds(waitSecond));
        return this;
    }
}