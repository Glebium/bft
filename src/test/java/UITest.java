import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
//import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;


// //*[@class='search3__logo-inner']

@Epic("UI тесты")
public class UITest {
    @Feature("Моя функциональность")
    @Story("Мой сценарий")
    @Test
    @Description("Проверка наличия иконки 'Яндекс' после поискового запроса")
    public void testYandexIcon() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;

        step("1. Открытие бразуера");
        open("https://ya.ru");

        step("2. Ввод текста в поисковую строку");
        $(By.name("text")).shouldBe(visible).setValue("БФТ");

        step("3. Нажатие на кнопку поиска");
        $(By.cssSelector(".search3__button")).shouldBe(visible).click();

        step("4. Проверка наличия иконки Яндекса");
        assertTrue($x("//a[@class='HeaderLogo']//*[local-name()='svg']").shouldBe(visible).isDisplayed());
    }
}
