package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.DemqaPage.StateItems;
import pages.DemqaPage.CityItems;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class Lst {
    private final SelenideElement element;
    private final List<SelenideElement> items;
    private final int waitSecond = 10;

    public Lst(SelenideElement element, SelenideElement... items) {
        this.element = element;
        this.items = Arrays.asList(items);
    }

    @Step("Выбор значения из выпадающего списка")
    public Lst chooseItem(Object item) {
        SelenideElement elem;
        if (item instanceof StateItems) {
            elem = ((StateItems) item).getValue();
        } else if (item instanceof CityItems) {
            elem = ((CityItems) item).getValue();
        } else {
            throw new IllegalArgumentException("авыаываыв");
        }
        element.shouldBe(Condition.exist, Duration.ofSeconds(waitSecond)).click();
        if (items.contains(elem)) {
            elem.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond)).click();
        } else {
            throw new IllegalArgumentException("Переданного аргумента нет в списке!");
        }
        return this;
    }

}