package tests.signUp;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import modals.EnrollMeModal;
import model.SignUp;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpTest() {
        logger.info("Step 1: Go to Login Page");
        getWebDriver().get("http://school-for-automation.tech");

        logger.info("Step 2: Sign In");
        LoginPage loginPage = new LoginPage(getWebDriver());
        HomePage homePage = loginPage.signIn("tester", "test1234");

        logger.info("Step 3: Go to Sign Up page");
        SignUpPage signUpPage = homePage.goToSignUp();

        logger.info("Step 4: Fill in the form");
        SignUp signUp = SignUp.builder()
                .courseIndex(2)
                .levelIndex(1)
                .studentName("Raul Gonzalez")
                .email("raul@madrid.com")
                .message("Builder Pattern rulez")
                .build();
        EnrollMeModal enrollMeModal = signUpPage.fillForm(signUp);

        logger.info("Step 5: Verify the modal output");
        verifyForm(enrollMeModal);
    }

    private void verifyForm(EnrollMeModal enrollMeModal) {
        Assert.assertEquals(enrollMeModal.getCourseName(), "Testing with Kafka");
        Assert.assertEquals(enrollMeModal.getLevel(), "Beginner");
        Assert.assertEquals(enrollMeModal.getStudentName(), "Raul Gonzalez");
        Assert.assertEquals(enrollMeModal.getEmailAddress(), "raul@madrid.com");
    }

}
