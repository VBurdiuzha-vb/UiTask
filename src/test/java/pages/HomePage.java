package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private final WebDriver webdriver;
    private Actions act;

    public HomePage(WebDriver webdriver) {
        this.webdriver = webdriver;
        act = new Actions(webdriver);
    }

    public void getPage() {
        webdriver.get("https://xm.com");
        webdriver.findElement(By.xpath("//button[contains(text(),'ACCEPT ALL')]")).click();
        webdriver.findElement(By.id("main-nav")).isDisplayed();
    }

    public void clickTradingTab() {
        act.moveToElement(webdriver.findElement(By.className("main_nav_trading"))).click();
        act.build().perform();
    }

    public void clickStock(){
        act.moveToElement(webdriver.findElement(By.linkText("Stocks"))).click();
        act.build().perform();
    }
}
