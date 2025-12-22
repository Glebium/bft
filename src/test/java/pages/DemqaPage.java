package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.elements.*;
import static com.codeborne.selenide.Selenide.*;


public class DemqaPage {
    public final Input firstName = new Input($("#firstName"));
    public final Input lastName = new Input($("#lastName"));
    public final Input email = new Input($("#userEmail"));
    public final RadioButton maleRadioButton = new RadioButton($x("//label[@for = \"gender-radio-1\"]"));
    public final RadioButton femaleRadioButton = new RadioButton($x("//label[@for = \"gender-radio-2\"]"));
    public final RadioButton otherRadioButton = new RadioButton($x("//label[@for = \"gender-radio-3\"]"));
    public final Input mobile = new Input($("#userNumber"));
    public final Input subjects = new Input($("#subjectsInput"));
    public final CheckBox sportsCheckBox = new CheckBox($x("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label"));
    public final CheckBox readingCheckBox = new CheckBox($x("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label"));
    public final CheckBox musicCheckBox = new CheckBox($x("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label"));
    public final Input picture = new Input($("#uploadPicture"));
    public final Input address = new Input($("#currentAddress"));
    public static final SelenideElement ncrStateItem = $("#react-select-3-option-0");
    public static final SelenideElement uttarPradeshStateItem = $("#react-select-3-option-1");
    public static final SelenideElement haryanaStateItem = $("#react-select-3-option-2");
    public static final SelenideElement rajasthanStateItem = $("#react-select-3-option-3");
    public static final SelenideElement delhiCityItem = $("#react-select-4-option-0");
    public static final SelenideElement gurgaonCityItem = $("#react-select-4-option-1");
    public static final SelenideElement noidaCityItem = $("#react-select-4-option-2");
    public final SelenideElement monthSelect = $x("//select[@class='react-datepicker__month-select']");
    public final SelenideElement yearSelect = $x("//select[@class='react-datepicker__year-select']");
    public final String dayPickerFormatString = "//div[contains(@class, 'react-datepicker__day') and text()='%d']";
    public final Button submitButton = new Button($("#submit"), "Кнопка отправки формы");
    public final PopupResults popupResults = new PopupResults($(".modal-content"));
    public final Lst city = new Lst($("#city"), delhiCityItem, gurgaonCityItem, noidaCityItem);
    public final Lst state = new Lst($("#state"), ncrStateItem, uttarPradeshStateItem, haryanaStateItem, rajasthanStateItem);
    public final Calend birthDate = new Calend($("#dateOfBirthInput"), dayPickerFormatString, monthSelect, yearSelect);


    public enum StateItems {
        NCR(ncrStateItem),
        UTTAR_PRADESH(uttarPradeshStateItem),
        HARYANA(haryanaStateItem),
        RAJAHSTAN(rajasthanStateItem);
        private final SelenideElement state;
        StateItems(SelenideElement state) {this.state = state;}
        public SelenideElement getValue() {return state;}
    }

    public enum CityItems {
        DELHI(delhiCityItem),
        GURGAON(gurgaonCityItem),
        NOIDA(noidaCityItem);
        private final SelenideElement city;
        CityItems(SelenideElement city) {this.city = city;}
        public SelenideElement getValue() {return city;}
    }


    @Step("Открытие браузера")
    public DemqaPage open() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        return this;
    }

//    @Step("Ввод текста в поисковую строку")
//    public DemqaFormPage setSearchInput(String query) {
//        searchElem.setValue(query);
//        return this;
//    }
//
//    @Step("Нажатие на кнопку поиска")
//    public DemqaFormPage clickSearchButtnon() {
//        searchButton.click();
//        return this;
//    }
}