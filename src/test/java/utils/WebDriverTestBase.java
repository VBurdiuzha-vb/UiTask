package utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.StocksPage;

import java.time.Duration;
import java.util.Map;
import java.util.stream.Collectors;

public class WebDriverTestBase {
    public org.openqa.selenium.WebDriver driver;

    public static FluentWait fluentWait;
    public static HomePage homePage;
    public static StocksPage stocksPage;

    @Before
    public void WebDriver() {
        String currentBrowser = System.getProperty("selenide.browser", "safari");
        if ("chrome".equals(currentBrowser)) {
            driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1024 , 768));
        } else if ("firefox".equals(currentBrowser)) {
            System.setProperty("webdriver.gecko.driver",  "src/main/resources/drivers/firefox/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().window().setSize(new Dimension(800, 600));
        }  else if ("safari".equals(currentBrowser)) {
            driver = new SafariDriver();
            driver.manage().window().fullscreen();
        }

        fluentWait = new FluentWait(driver);

        homePage = PageFactory.initElements(driver, HomePage.class);
        stocksPage = PageFactory.initElements(driver, StocksPage.class);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void waitUntilPageLoaded(WebDriver driver){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                webDriver ->
                        ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static void setFluentWait(WebDriver driver, WebElement element){
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(2))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);

        wait.until(
                d -> {
                    element.isDisplayed();
                    return true;
                });
    }

    public static Map<String, Boolean> comparingConditions(Map<String, String> first, Map<String, String> second) {
        return first.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(),
                        e -> e.getValue().equals(second.get(e.getKey()))));
    }

}
