import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Test;
import settings.BaseTest;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Epic("UI тесты")
public class UITest extends BaseTest {
    @Test
    @Description("Проверка наличия иконки 'Яндекс' после поискового запроса")
    public void testYandexIcon() {
        searchPage.open().setSearchInput("БФТ").clickSearchButtnon();
        Selenide.sleep(3000);

        step("Проверка наличия иконки Яндекса");
        assertTrue($x("//a[@class='HeaderLogo']//*[local-name()='svg']").isDisplayed());
    }
}
