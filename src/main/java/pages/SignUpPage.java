package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import lombok.Getter;
import lombok.Setter;
import modals.EnrollMeModal;
import model.SignUp;

@Getter
@Setter
public class SignUpPage extends BasePage {

    @FindBy(name = "radio")
    private List<WebElement> radioButtons;

    @FindBy(name = "name")
    private WebElement studentNameInput;

    @FindBy(name = "email")
    private WebElement studentEmailInput;

    @FindBy(name = "message")
    private WebElement messageInput;

    @FindBy(xpath = "//*[@id=\"contact\"]/div[1]/button")
    private WebElement enrollMeButton;

    @FindBy(id = "slct")
    private WebElement selectElement;

    private Select select;

    public SignUpPage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
        setSelect(new Select(selectElement));
    }

    public EnrollMeModal fillForm(SignUp signUp) {
        chooseCourse(signUp.getCourseIndex());
        chooseLevel(signUp.getLevelIndex());
        insertName(signUp.getStudentName());
        insertEmail(signUp.getEmail());
        insertMessage(signUp.getMessage());

        return enrollMe();
    }

    private void chooseCourse(int index) {
        getRadioButtons().get(index).click();
    }

    private void chooseLevel(int index) {
        getSelect().selectByIndex(index);
    }

    private void insertName(String name) {
        getStudentNameInput().sendKeys(name);
    }

    private void insertEmail(String email) {
        getStudentEmailInput().sendKeys(email);
    }

    private void insertMessage(String message) {
        getMessageInput().sendKeys(message);
    }

    private EnrollMeModal enrollMe() {
        getEnrollMeButton().click();

        return new EnrollMeModal(getWebDriver());
    }
}
