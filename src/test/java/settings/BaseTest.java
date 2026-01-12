package settings;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.DemqaPage;
import pages.SearchPage;
import static com.codeborne.selenide.Configuration.*;

public class BaseTest {
    public SearchPage searchPage = new SearchPage();
    public DemqaPage demqaPage = new DemqaPage();

    public static void setLocalConfiguration() {
        timeout = 70_000;
        holdBrowserOpen = true;
        browserSize = "1920x1080";
        browser = "chrome";
        pageLoadTimeout = 90_000;
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
