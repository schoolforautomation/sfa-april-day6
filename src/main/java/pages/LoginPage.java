package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit")
    private WebElement loginButton;

    @FindBy(id = "error")
    private WebElement errorLabel;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public HomePage signIn(String userName, String password) {
        getUsernameInput().sendKeys(userName);
        getPasswordInput().sendKeys(password);
        getLoginButton().click();

        return new HomePage(getWebDriver());
    }

    public void signInWithInvalidCredentials(String userName, String password) {
        getUsernameInput().sendKeys(userName);
        getPasswordInput().sendKeys(password);
        getLoginButton().click();
    }
}
