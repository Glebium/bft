package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.elements.Button;
import static com.codeborne.selenide.Selenide.$;


public class SearchPage {
    private final SelenideElement searchElem = $(By.name("text"));
    private final SelenideElement searchButtonElem = $(By.cssSelector(".search3__button"));
    private final Button searchButton = new Button(searchButtonElem, "Поиск");

    @Step("Открытие браузера")
    public SearchPage open() {
        Selenide.open("https://ya.ru");
        return this;
    }

    @Step("Ввод текста в поисковую строку")
    public SearchPage setSearchInput(String query) {
        searchElem.setValue(query);
        return this;
    }

    @Step("Нажатие на кнопку поиска")
    public SearchPage clickSearchButtnon() {
        searchButton.click();
        return this;
    }
}