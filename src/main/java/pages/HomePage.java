package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomePage extends BasePage {

    private WebElement getStartedButton;

    public HomePage(final WebDriver webDriver) {
        super(webDriver);
        findGetStartedButton();
    }

    public void findGetStartedButton() {
        setGetStartedButton(new WebDriverWait(getWebDriver(), 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("get-started"))));
    }

    public SignUpPage goToSignUp() {
        getGetStartedButton().click();

        return new SignUpPage(getWebDriver());
    }
}
