package seleniumTests;

import base.DataGenerator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import selenium.pages.MainPage;

public class SubmitRequestTests extends BaseTest {

    @Test
    public void fillForm_WithValidData_CorrectSubmitting() {

        // Arrange
        var expectedHeader = " Thank you!";

        // Act
        var mainPage = new MainPage.MainPageBuilder(driver);

        mainPage = mainPage
                .setFirstName(DataGenerator.generateString(5))
                .setLastName(DataGenerator.generateString(5))
                .setBusinessName(DataGenerator.generateString(5))
                .setEmail(DataGenerator.generateEmail())
                .setResultField();

        mainPage = mainPage.clickSubmitBtn();

        var successLabel = mainPage.getNewMainPage().getSuccessLabel();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOf(successLabel));

        var actualHeader = successLabel.getAttribute("textContent");

        // Assert
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
    public void fillForm_WithoutEmail_ExpectAlertWithMessage() {

        // Arrange
        var expectedMessage = "Please type your email name";

        // Act
        var mainPage = new MainPage.MainPageBuilder(driver);

        mainPage
                .setFirstName(DataGenerator.generateString(5))
                .setLastName(DataGenerator.generateString(5))
                .setBusinessName(DataGenerator.generateString(5))
                .setResultField()
                .clickSubmitBtn();

        var actualMessage = driver.switchTo().alert().getText();

        // Assert
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void fillForm_WithoutFirstName_ExpectAlertWithMessage() {

        // Arrange
        var expectedMessage = "Please type your first name";

        // Act
        var mainPage = new MainPage.MainPageBuilder(driver);

        mainPage
                .setLastName(DataGenerator.generateString(5))
                .setBusinessName(DataGenerator.generateString(5))
                .setEmail(DataGenerator.generateEmail())
                .setResultField()
                .clickSubmitBtn();

        var actualMessage = driver.switchTo().alert().getText();

        // Assert
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void fillForm_WithoutLastName_ExpectAlertWithMessage() {

        // Arrange
        var expectedMessage = "Please type your last name";

        // Act
        var mainPage = new MainPage.MainPageBuilder(driver);

        mainPage
                .setFirstName(DataGenerator.generateString(5))
                .setBusinessName(DataGenerator.generateString(5))
                .setEmail(DataGenerator.generateEmail())
                .setResultField()
                .clickSubmitBtn();

        var actualMessage = driver.switchTo().alert().getText();

        // Assert
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void fillForm_WithoutBusinessName_ExpectAlertWithMessage() {

        // Arrange
        var expectedMessage = "Please type your business name";

        // Act
        var mainPage = new MainPage.MainPageBuilder(driver);

        mainPage
                .setFirstName(DataGenerator.generateString(5))
                .setLastName(DataGenerator.generateString(5))
                .setEmail(DataGenerator.generateEmail())
                .setResultFieldWithCustomValues(10000)
                .clickSubmitBtn();

        var actualMessage = driver.switchTo().alert().getText();

        // Assert
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
