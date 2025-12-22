package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class PopupResults {
    SelenideElement element;
    SelenideElement table = $("body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody");
    Button closeButton = new Button($("#closeLargeModal"), "Кнопка закрытия popup");
    private final int waitSecond = 10;

    public PopupResults(SelenideElement element) {
        this.element = element;
    }

    private void checkExists() {
        table.shouldBe(Condition.exist, Duration.ofSeconds(waitSecond));
    }

    @Step("Таблица (popup). Проверка заполнения имени")
    public PopupResults checkName(String name) {
        checkExists();
        ElementsCollection rows = table.findAll("tr");
        ElementsCollection cells = rows.get(0).findAll("td");
        cells.get(0).shouldHave(Condition.text("Student Name"));
        cells.get(1).shouldHave(Condition.text(name));
        return this;
    }

    @Step("Таблица (popup). Проверка заполнения адреса эл. почты")
    public PopupResults checkEmail(String email) {
        checkExists();
        ElementsCollection rows = table.findAll("tr");
        ElementsCollection cells = rows.get(1).findAll("td");
        cells.get(0).shouldHave(Condition.text("Student Email"));
        cells.get(1).shouldHave(Condition.text(email));
        return this;
    }

    @Step("Таблица (popup). Проверка заполнения пола")
    public PopupResults checkGender(String gender) {
        checkExists();
        ElementsCollection rows = table.findAll("tr");
        ElementsCollection cells = rows.get(2).findAll("td");
        cells.get(0).shouldHave(Condition.text("Gender"));
        cells.get(1).shouldHave(Condition.text(gender));
        return this;
    }

    @Step("Таблица (popup). Проверка заполнения мобильного телефона")
    public PopupResults checkMobile(String mobile) {
        checkExists();
        ElementsCollection rows = table.findAll("tr");
        ElementsCollection cells = rows.get(3).findAll("td");
        cells.get(0).shouldHave(Condition.text("Mobile"));
        cells.get(1).shouldHave(Condition.text(mobile));
        return this;
    }

    @Step("Таблица (popup). Проверка заполнения даты рождения")
    public PopupResults checkBirthDate(String birthDate) {
        checkExists();
        ElementsCollection rows = table.findAll("tr");
        ElementsCollection cells = rows.get(4).findAll("td");
        cells.get(0).shouldHave(Condition.text("Date of Birth"));
        cells.get(1).shouldHave(Condition.text(birthDate));
        return this;
    }

    @Step("Таблица (popup). Проверка заполнения subjects")
    public PopupResults checkSubjects(String subjects) {
        checkExists();
        ElementsCollection rows = table.findAll("tr");
        ElementsCollection cells = rows.get(5).findAll("td");
        cells.get(0).shouldHave(Condition.text("Subjects"));
        cells.get(1).shouldHave(Condition.text(subjects));
        return this;
    }

    @Step("Таблица (popup). Проверка заполнения хобби")
    public PopupResults checkHobbies(String hobbies) {
        checkExists();
        ElementsCollection rows = table.findAll("tr");
        ElementsCollection cells = rows.get(6).findAll("td");
        cells.get(0).shouldHave(Condition.text("Hobbies"));
        cells.get(1).shouldHave(Condition.text(hobbies));
        return this;
    }

    @Step("Таблица (popup). Проверка загрузки файла")
    public PopupResults checkFile(String fileName) {
        checkExists();
        ElementsCollection rows = table.findAll("tr");
        ElementsCollection cells = rows.get(7).findAll("td");
        cells.get(0).shouldHave(Condition.text("Picture"));
        cells.get(1).shouldHave(Condition.text(fileName));
        return this;
    }

    @Step("Таблица (popup). Проверка заполнения адреса")
    public PopupResults checkAddress(String address) {
        checkExists();
        ElementsCollection rows = table.findAll("tr");
        ElementsCollection cells = rows.get(8).findAll("td");
        cells.get(0).shouldHave(Condition.text("Address"));
        cells.get(1).shouldHave(Condition.text(address));
        return this;
    }

    @Step("Таблица (popup). Проверка заполнения региона и города")
    public PopupResults checkStateAndCity(String stateAndCity) {
        checkExists();
        ElementsCollection rows = table.findAll("tr");
        ElementsCollection cells = rows.get(9).findAll("td");
        cells.get(0).shouldHave(Condition.text("State and City"));
        cells.get(1).shouldHave(Condition.text(stateAndCity));
        return this;
    }

    public PopupResults close() {
        closeButton.click();
        return this;
    }
}
