package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import exceptions.TextNotFoundException;

public class SeleniumUtils {

    public static String getElementText(WebElement webElement) throws InterruptedException, TextNotFoundException {
        int count = 0;
        int maximumTries = 5;

        while (webElement.getText().equals("")) {
            TimeUnit.MILLISECONDS.sleep(500);
            count++;

            if (count >= maximumTries) {
                throw new TextNotFoundException("Could not find text for the specified WebElement.");
            }
        }

        return webElement.getText();
    }
}
