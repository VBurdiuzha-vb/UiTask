package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class XmPage {
    private final WebDriver webdriver;

    @FindBy(css = "[class=navbar-brand logo]")
    private WebElement navbarBrandLogo;

    public XmPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public void getPage() {
        //TODO continue from here
        webdriver.get("https://xm.com");
        new WebDriverWait(webdriver, Duration.ofSeconds(5)).until(visibilityOfElementLocated((By) navbarBrandLogo));
    }
}
