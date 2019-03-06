package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultSimultionPageObjects {
    private WebDriver driver;

    public ResultSimultionPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTimeInvestmentLabel(){
        return driver.findElement(By.cssSelector("span[class='texto']>strong"));
    }

    public WebElement getSavingsValueInvestmentLabel(){
        return driver.findElement(By.xpath("//span[@class='valor']"));
    }
}
