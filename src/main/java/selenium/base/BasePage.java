package selenium.base;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BasePage {

    public void goToNextWindow(WebDriver driver) {

        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String ChildWindow : allWindowHandles) {
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
            }
        }
    }
}
