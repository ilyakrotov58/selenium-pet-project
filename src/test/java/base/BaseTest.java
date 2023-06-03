package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {

    protected static WebDriver driver;
    public static Properties config;
    WebDriverWait wait;

    private static final String BROWSER = System.getProperty("browser", "Chrome");

    @BeforeSuite
    public void suiteSetup() throws IOException {

        if (BROWSER.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else {
            throw new RuntimeException("Browser type unsupported");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 20);

        config = new Properties();
        config.load(new FileInputStream("src/main/resources/application.properties"));
    }

    @BeforeMethod()
    public void loadBaseUrl(Method method) {
        driver.get(config.getProperty("baseUrl"));
    }

    @AfterSuite
    public void suiteTearDown() {
        driver.quit();
    }
}