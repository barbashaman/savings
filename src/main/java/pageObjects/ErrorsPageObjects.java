package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorsPageObjects {

    public WebDriver driver;

    public ErrorsPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getValorAplicarErrorLabel(){
        return this.driver.findElement(By.id("valorAplicar-error"));
    }

    public WebElement getValorInvestirErrorLabel(){
        return this.driver.findElement(By.id("valorInvestir-error"));
    }

    public WebElement getTempoErrorLabel(){
        return this.driver.findElement(By.id("tempo-error"));
    }
}
