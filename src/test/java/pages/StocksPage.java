package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class StocksPage {

    private final org.openqa.selenium.WebDriver driver;
    private Actions act;
    public StocksPage(WebDriver webdriver) {
        this.driver = webdriver;
        act = new Actions(webdriver);
    }

    public void clickNorwayFilter(){
        act.moveToElement(driver.findElement(By.xpath("//*[@id=\"cash\"]/div/div[1]/button[12]"))).click();
        act.build().perform();
    }

    public Map<String, String> getDataFromTableByRowNumber(int rowNumber){
        Map<String, String> rowMap = new HashMap<>();
        for (int i = 1; i <=8 ; i++) {
        String rowValue =
                driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[" + rowNumber + "]/td[" + i + "]")).getText();
        String columnValue =
                    driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/thead/tr/th[" + i + "]")).getText();
            rowMap.put(columnValue, rowValue);
        }
        return rowMap;
    }

    public Integer findRowInTableByDescription(String description){
        int expectedRowNumber = 1;
        int rows = driver.findElements(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr")).size();
        for (int i = 1; i <= rows; i++) {
            if(driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[" + i + "]/td[1]"))
                    .getText().contains(description)){
                expectedRowNumber = i;
            }
        }
        return expectedRowNumber;
    }
    public void clickReadMoreForSpecificRow(int rowNumb){
        act.moveToElement(driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[" + rowNumb +"]/td[9]/a"))).click();
        act.build().perform();
    }

    public void selectCountInDropDawn(){
        Select drpCountry = new Select(driver.findElement(By.name("DataTables_Table_0_length")));
        drpCountry.selectByIndex(1);
    }

    public Map<String, String> getTradingConditionsData(){
        Map<String, String> tradingConditionsMap = new HashMap<>();

        int rows = driver.findElements(By.xpath("//*[@class=\"table pull-right\"]/tbody/tr")).size();
        for (int i = 1; i <= rows ; i++) {
            String nameLeftSide =
                    driver.findElement(By.xpath("//*[@id=\"instrument-inner-page\"]/div[1]/div/div[1]/table/tbody/tr[" + i + "]/td[1]")).getText();
            String valueLeftSide =
                    driver.findElement(By.xpath("//*[@id=\"instrument-inner-page\"]/div[1]/div/div[1]/table/tbody/tr[" + i + "]/td[2]")).getText();
            tradingConditionsMap.put(nameLeftSide, valueLeftSide);

            String nameRightSide =
                    driver.findElement(By.xpath("//*[@id=\"instrument-inner-page\"]/div[1]/div/div[2]/table/tbody/tr[" + i + "]/td[1]")).getText();
            String valueRightSide =
                    driver.findElement(By.xpath("//*[@id=\"instrument-inner-page\"]/div[1]/div/div[2]/table/tbody/tr[" + i + "]/td[2]")).getText();
            tradingConditionsMap.put(nameRightSide, valueRightSide);
        }

        return tradingConditionsMap;
    }
}
