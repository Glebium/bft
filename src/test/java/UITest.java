import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Epic("UI тесты")
public class UITest {
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
