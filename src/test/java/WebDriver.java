import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriver {
    protected static org.openqa.selenium.WebDriver driver;

    @Before
    public void WebDriver() {
        String currentBrowser = System.getProperty("selenide.browser", "firefox");
        if ("chrome".equals(currentBrowser)) {
            driver = new ChromeDriver();
            driver.manage().window().fullscreen();
        } else if ("edge".equals(currentBrowser)) {
            driver = new EdgeDriver();
        } else if ("firefox".equals(currentBrowser)) {
            System.setProperty("webdriver.gecko.driver",  "src/main/resources/geckodriver/firefox/geckodriver");
            driver = new FirefoxDriver();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
