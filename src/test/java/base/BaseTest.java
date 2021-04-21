package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseTest {

    private WebDriver webDriver;

    public static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        setWebDriver(new ChromeDriver());
        getWebDriver().manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        getWebDriver().quit();
    }
}
