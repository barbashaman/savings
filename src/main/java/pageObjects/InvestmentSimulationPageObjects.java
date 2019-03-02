package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InvestmentSimulationPageObjects {

    public WebElement getParaVoceRadioButton(WebDriver driver){
        return driver.findElement(By.cssSelector("input[name='perfil'][value='paraVoce']"));
    }

    public WebElement getParaSuaEmpresaRadioButton(WebDriver driver){
        return driver.findElement(By.cssSelector("input[name='perfil'][value='paraEmpresa']"));
    }

    public WebElement getValorAplicarTextField(WebDriver driver){
        return driver.findElement(By.id("valorAplicar"));
    }

    public WebElement getValorInvestirTextField(WebDriver driver){
        return driver.findElement(By.id("valorInvestir"));
    }

    public WebElement getTempoInvestimentoTextField(WebDriver driver){
        return driver.findElement(By.id("tempo"));
    }

    public WebElement getAnoButton(WebDriver driver){
        return driver.findElement(By.cssSelector("a[rel='A']"));
    }

    public WebElement getMesesButton(WebDriver driver){
        return driver.findElement(By.cssSelector("a[rel='M']"));
    }

    public WebElement getLimparFormularioButton(WebDriver driver){
        return driver.findElement(By.cssSelector("a[class*='btnLimpar']"));
    }

    public WebElement getSimularButton(WebDriver driver){
        return driver.findElement(By.cssSelector("a[class*='btnSimular']"));
    }
}
