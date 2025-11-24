package settings;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.SearchPage;
import static com.codeborne.selenide.Configuration.*;

public class BaseTest {
    public SearchPage searchPage = new SearchPage();

    public static void setLocalConfiguration() {
        timeout = 10_000;
        holdBrowserOpen = true;
        browser = "chrome";
    }

    @BeforeAll
    public static void setup() {
        setLocalConfiguration();
    }

    @AfterEach
    public void closeDriver() {
        Selenide.closeWebDriver();
    }
}
