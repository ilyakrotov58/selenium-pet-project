package seleniumTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.pages.LoginPage;
import selenium.pages.MainPage;

public class LoginPageTests extends BaseTest {

    @Test
    public void goToLoginPage_CheckLoginButton_LoginBtnIsEnabled() {

        // Arrange
        var mainPage = new MainPage.MainPageBuilder(driver);

        // Act
        mainPage.getNewMainPage().getLoginBtn().click();
        mainPage.getNewMainPage().goToNextWindow(driver);

        var loginPage = new LoginPage(driver);

        // Assert
        Assert.assertTrue(loginPage.getBtnLogin().isEnabled());
    }
}
