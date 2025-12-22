package pages.elements;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.time.Duration;


public class Input extends Field {
    private final SelenideElement element;
    private final int waitSecond = 10;

    public Input(SelenideElement element) {this.element = element;}
    
    public Input scroll() {
        element.scrollIntoView(true);
        return this;
    }

    public Input clear() {
        element.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond)).clear();
        return this;
    }

    @Step("Ввод значения в поле")
    public Input set(String text) {
        element.shouldBe(Condition.enabled, Duration.ofSeconds(waitSecond)).setValue(text);
        return this;
    }

    @Step("Выбор значения из выпадающего списка-автоподсказки")
    public Input chooseSubjectFromAutoComplete() {
        SelenideElement chooseSubject = $("#react-select-2-option-0");
        chooseSubject.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        return this;
    }

    @Step("Загрузка файла")
    public Input uploadFile(File file) {
        element.uploadFile(file);
        return this;
    }

    @Step("Проверка цвета границы элемента")
    public Input checkBorderColor(Field.Color rgb) {
        element.shouldBe(Condition.cssValue("border-color", rgb.getValue()), Duration.ofSeconds(waitSecond));
        return this;
    }
}
