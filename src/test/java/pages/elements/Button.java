package pages.elements;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class Button {
    SelenideElement element;
    String name;

    public Button(SelenideElement element, String name) {
        this.element = element;
        this.name = name;
    }

    public void click() {
        element.shouldBe(Condition.enabled);
        element.click();
    }
}
