package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InvestmentSimulationPageObjects {

    private WebDriver driver;

    public InvestmentSimulationPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getParaVoceRadioButton(){
        return driver.findElement(By.cssSelector("input[name='perfil'][value='paraVoce']"));
    }

    public WebElement getParaSuaEmpresaRadioButton(){
        return driver.findElement(By.cssSelector("input[name='perfil'][value='paraEmpresa']"));
    }

    public WebElement getValorAplicarTextField(){
        return driver.findElement(By.id("valorAplicar"));
    }

    public WebElement getValorInvestirTextField(){
        return driver.findElement(By.id("valorInvestir"));
    }

    public WebElement getTempoInvestimentoTextField(){
        return driver.findElement(By.cssSelector("input[id='tempo']"));
    }

    public WebElement getTipoTempoDropDown(){
        return driver.findElement(By.cssSelector("a[class*='btSelect']"));
    }

    public WebElement getAnosButton(){
        return driver.findElement(By.cssSelector("a[rel='A']"));
    }

    public WebElement getMesesButton(){
        return driver.findElement(By.cssSelector("a[rel='M']"));
    }

    public WebElement getLimparFormularioButton(){
        return driver.findElement(By.cssSelector("a[class*='btnLimpar']"));
    }

    public WebElement getSimularButton(){
        return driver.findElement(By.cssSelector("button[class*='btnSimular']"));
    }
}
