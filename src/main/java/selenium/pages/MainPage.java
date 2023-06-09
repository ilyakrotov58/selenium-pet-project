package selenium.pages;

import lombok.Data;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.base.BasePage;

@Getter
public class MainPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement txtFirstName;
    @FindBy(xpath = "//input[@name='last_name']")
    WebElement txtLastName;
    @FindBy(xpath = "//input[@name='business_name']")
    WebElement txtBusinessName;
    @FindBy(xpath = "//input[@name='email']")
    WebElement txtEmail;
    @FindBy(id = "demo")
    WebElement btnSubmit;
    @FindBy(id = "number")
    WebElement txtResultField;
    @FindBy(id = "numb1")
    static WebElement elemFirstNumber;
    @FindBy(id = "numb2")
    static WebElement elemSecondNumber;
    @FindBy(xpath = "//div[@class='completed']/h2/strong")
    WebElement successLabel;
    @FindBy(xpath = "//div[@class='nav_right']//li[1]")
    WebElement loginBtn;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSuccessLabel() {
        return successLabel;
    }

    private static int getSumOfNumbers() {
        var firstNumber = Byte.parseByte(getFirstNumber());
        var secondNumber = Byte.parseByte(getSecondNumber());

        return firstNumber + secondNumber;
    }

    private static String getFirstNumber() {
        return elemFirstNumber.getText();
    }

    private static String getSecondNumber() {
        return elemSecondNumber.getText();
    }

    @Data
    public static class MainPageBuilder {

        private MainPage newMainPage;

        public MainPageBuilder(WebDriver driver) {
            newMainPage = new MainPage(driver);
        }

        public MainPageBuilder setFirstName(String firstName) {
            newMainPage.txtFirstName.sendKeys(firstName);
            return this;
        }

        public MainPageBuilder setLastName(String lastName) {
            newMainPage.txtLastName.sendKeys(lastName);
            return this;
        }

        public MainPageBuilder setBusinessName(String businessName) {
            newMainPage.txtBusinessName.sendKeys(businessName);
            return this;
        }

        public MainPageBuilder setEmail(String email) {
            newMainPage.txtEmail.sendKeys(email);
            return this;
        }

        public MainPageBuilder setResultField() {
            newMainPage.txtResultField.sendKeys(String.valueOf(getSumOfNumbers()));
            return this;
        }

        public MainPageBuilder setResultFieldWithCustomValues(int sum) {
            newMainPage.txtResultField.sendKeys(String.valueOf(sum));
            return this;
        }

        public MainPageBuilder clickSubmitBtn() {
            newMainPage.btnSubmit.click();
            return this;
        }
    }
}
