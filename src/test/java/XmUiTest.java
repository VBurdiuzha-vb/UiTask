import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import utils.WebDriverTestBase;

import java.time.Duration;
import java.util.Map;

public class XmUiTest extends WebDriverTestBase {

    @Test
    public void readTradingCondition() throws InterruptedException {
        homePage.getPage();
        homePage.clickTradingTab();
        homePage.clickStock();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(2000); //TODO
        ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
        Thread.sleep(2000); //TODO
        stocksPage.clickNorwayFilter();
        Thread.sleep(2000); //TODO
        stocksPage.selectCountInDropDawn();
        Thread.sleep(2000); //TODO
        int rowNumber = stocksPage.findRowInTableByDescription("Orkla ASA (ORK.OL)");
        Map<String, String> stocksSpreadsConditions = stocksPage.getDataFromTableByRowNumber(rowNumber);
        ((JavascriptExecutor)driver).executeScript("scroll(0,2800)");
        Thread.sleep(2000); //TODO
        stocksPage.clickReadMoreForSpecificRow(rowNumber);
        Thread.sleep(3000); //TODO
        ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
        Thread.sleep(2000); //TODO
        Map<String, String> tradingConditionsMap = stocksPage.getTradingConditionsData();
        Map<String, Boolean> matchedConditions = comparingConditions(stocksSpreadsConditions, tradingConditionsMap);
        matchedConditions.forEach((k,v) -> System.out.println(k + " : " + v));
    }
}
