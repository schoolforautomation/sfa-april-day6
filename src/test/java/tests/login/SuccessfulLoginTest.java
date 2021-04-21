package tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class SuccessfulLoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        logger.info("Step 1: Go to Login Page");
        getWebDriver().get("http://school-for-automation.tech");

        logger.info("Step 2: Sign In");
        LoginPage loginPage = new LoginPage(getWebDriver());
        HomePage homePage = loginPage.signIn("tester", "test1234");

        logger.info("Step 3: Verify the Get Started button is displayed");
        Assert.assertTrue(homePage.getGetStartedButton().isDisplayed());
    }
}
