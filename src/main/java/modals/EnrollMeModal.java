package modals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseModal;
import exceptions.TextNotFoundException;
import lombok.Getter;
import lombok.Setter;

import static utils.SeleniumUtils.getElementText;

@Getter
@Setter
public class EnrollMeModal extends BaseModal {

    @FindBy(id = "studentName")
    private WebElement studentNameSpan;

    @FindBy(id = "courseName")
    private WebElement courseNameSpan;

    @FindBy(id = "level")
    private WebElement levelSpan;

    @FindBy(id = "emailAddr")
    private WebElement emailAddressSpan;

    public EnrollMeModal(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public String getStudentName() throws TextNotFoundException, InterruptedException {
        return getElementText(getStudentNameSpan());
    }

    public String getCourseName() throws TextNotFoundException, InterruptedException {
        return getElementText(getCourseNameSpan());
    }

    public String getLevel() throws TextNotFoundException, InterruptedException {
        return getElementText(getLevelSpan());
    }

    public String getEmailAddress() throws TextNotFoundException, InterruptedException {
        return getElementText(getEmailAddressSpan());
    }

}
