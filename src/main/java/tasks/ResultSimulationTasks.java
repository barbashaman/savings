package tasks;

import browser.Browser;
import org.openqa.selenium.interactions.Actions;
import pageObjects.ResultSimultionPageObjects;

import java.util.concurrent.TimeUnit;

public class ResultSimulationTasks {

    private Browser browser;
    private ResultSimultionPageObjects resultSimultion;

    public ResultSimulationTasks(Browser browser) {
        this.browser = browser;
        this.resultSimultion = new ResultSimultionPageObjects(browser.getDriver());
    }

    public boolean isTimeCorrect(String time, String timeType) {
        browser.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        new Actions(browser.getDriver()).moveToElement(resultSimultion.getTimeInvestmentLabel()).perform();
//        ((JavascriptExecutor) browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);",resultSimultion.getTimeInvestmentLabel());
        return resultSimultion.getTimeInvestmentLabel().getAttribute("innerText").contains(time) &&
                resultSimultion.getTimeInvestmentLabel().getAttribute("innerText").contains(timeType.toLowerCase());
    }

    public boolean isValueCorrect(String valor){
        browser.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        new Actions(browser.getDriver()).moveToElement(resultSimultion.getSavingsValueInvestmentLabel()).perform();
//        ((JavascriptExecutor) browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", resultSimultion.getSavingsValueInvestmentLabel());
        return resultSimultion.getSavingsValueInvestmentLabel().getAttribute("innerText").contains(valor);
    }
}
