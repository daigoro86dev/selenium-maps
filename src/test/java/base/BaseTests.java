package test.java.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import main.java.pages.AcceptCookiesPage;
import main.java.pages.MapsPage;

public class BaseTests {

    private WebDriver driver;
    private static String OS;
    private AcceptCookiesPage acceptCookiesPage;
    protected MapsPage mapsPage;

    @BeforeClass
    public void setup() throws Exception{
        OS = System.getProperty("os.name").toLowerCase();

        if (OS.contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("headless");

        driver = new ChromeDriver(options);
        driver.get("https://www.google.com/maps");
        acceptCookiesPage = new AcceptCookiesPage(driver);
        mapsPage = acceptCookiesPage.clickAcceptCookiesButton();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
