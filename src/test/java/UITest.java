import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import settings.BaseTest;
import java.io.File;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.DemqaPage.StateItems.UTTAR_PRADESH;
import static pages.DemqaPage.StateItems.HARYANA;
import static pages.DemqaPage.StateItems.RAJAHSTAN;
import static pages.DemqaPage.StateItems.NCR;
import static pages.DemqaPage.CityItems.DELHI;
import static pages.DemqaPage.CityItems.GURGAON;
import static pages.DemqaPage.CityItems.NOIDA;
import static pages.elements.Field.Color.RED;
import static pages.elements.Field.Color.GREEN;


@Epic("UI test")
public class UITest extends BaseTest {
    @Test
    @Description("Проверка наличия иконки 'Яндекс' после поискового запроса")
    @Disabled
    public void testYandexIcon() {
        searchPage.open().setSearchInput("БФТ").clickSearchButtnon();
        Selenide.sleep(3000);

        step("Проверка наличия иконки Яндекса");
        assertTrue($x("//a[@class='HeaderLogo']//*[local-name()='svg']").isDisplayed());
    }

    @Test
    @Description("Проверка заполнения формы и отображения результатов в popup таблице")
    public void testPopupTable() {
        demqaPage.open();
        // Заполнение формы
        demqaPage.firstName.set("Иван");
        demqaPage.lastName.set("Иванов");
        demqaPage.email.set("1223@gmail.com");
        demqaPage.maleRadioButton.select();
        demqaPage.mobile.set("1234567890");
        demqaPage.birthDate.set(23, "November", "1994");
        demqaPage.subjects.set("English").chooseSubjectFromAutoComplete();
        demqaPage.sportsCheckBox.click();
        demqaPage.picture.uploadFile(new File("src/test/java/utils/test_file.txt"));
        demqaPage.address.set("addr");
        demqaPage.state.chooseItem(NCR);
        demqaPage.city.chooseItem(DELHI);
        demqaPage.submitButton.click();
        //Проверка заполнения popup таблицы
        demqaPage.popupResults.checkName("Иван Иванов");
        demqaPage.popupResults.checkEmail("1223@gmail.com");
        demqaPage.popupResults.checkGender("Male");
        demqaPage.popupResults.checkMobile("1234567890");
        demqaPage.popupResults.checkBirthDate("23 November,1994");
        demqaPage.popupResults.checkSubjects("English");
        demqaPage.popupResults.checkHobbies("Sports");
        demqaPage.popupResults.checkFile("test_file.txt");
        demqaPage.popupResults.checkAddress("addr");
        demqaPage.popupResults.checkStateAndCity("NCR Delhi");
    }

    @Test
    @Description("Проверка валидации полей при незаполнении формы")
    public void testFormFieldsBorderColor() {
        demqaPage.open();
        demqaPage.submitButton.click();
        // Проверка подсветки полей при корректном/некорректном заполнении поля
        demqaPage.firstName.checkBorderColor(RED);
        demqaPage.lastName.checkBorderColor(RED);
        demqaPage.email.checkBorderColor(GREEN);
        demqaPage.maleRadioButton.checkBorderColor(RED);
        demqaPage.femaleRadioButton.checkBorderColor(RED);
        demqaPage.otherRadioButton.checkBorderColor(RED);
        demqaPage.sportsCheckBox.checkBorderColor(GREEN);
        demqaPage.readingCheckBox.checkBorderColor(GREEN);
        demqaPage.musicCheckBox.checkBorderColor(GREEN);
        demqaPage.address.checkBorderColor(GREEN);
        demqaPage.birthDate.checkBorderColor(GREEN);
    }
}
