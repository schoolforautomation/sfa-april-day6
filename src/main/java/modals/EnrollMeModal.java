package modals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseModal;
import lombok.Getter;
import lombok.Setter;

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

    public String getStudentName() {
        return getStudentNameSpan().getText();
    }

    public String getCourseName() {
        return getCourseNameSpan().getText();
    }

    public String getLevel() {
        return getLevelSpan().getText();
    }

    public String getEmailAddress() {
        return getEmailAddressSpan().getText();
    }

}
