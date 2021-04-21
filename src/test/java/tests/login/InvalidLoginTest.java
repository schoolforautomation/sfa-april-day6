package tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() {
        logger.info("Step 1: Go to Login Page");
        getWebDriver().get("http://school-for-automation.tech");

        logger.info("Step 2: Sign In");
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.signInWithInvalidCredentials("invalid", "test1234");

        logger.info("Step 3: Verify the Error label is displayed");
        Assert.assertTrue(loginPage.getErrorLabel().isDisplayed());
    }
}
