import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.pages.MainPage;

public class LoginPageTests extends BaseTest {

    @Test
    public void goToLoginPage_CheckLoginButton_LoginBtnIsEnabled() {

        // Arrange
        var mainPage = new MainPage.MainPageBuilder(driver);

        // Act
        var loginPage = mainPage.getNewMainPage().goToLoginPage(driver);

        // Assert
        Assert.assertTrue(loginPage.getBtnLogin().isEnabled());
    }
}
