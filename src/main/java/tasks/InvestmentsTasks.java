package tasks;

import browser.Browser;
import org.openqa.selenium.JavascriptExecutor;
import pageObjects.InvestmentSimulationPageObjects;

public class InvestmentsTasks {

    private InvestmentSimulationPageObjects investment;
    private Browser browser;

    public InvestmentsTasks(Browser browser) {
        this.browser = browser;
        this.investment = new InvestmentSimulationPageObjects(browser.getDriver());
    }

    public void makeInvestment(String perfil, String aplicacao, String poupanca, String tempo, String tipoTempo) {
        if (perfil.equalsIgnoreCase("Para você")) {
            investment.getParaVoceRadioButton().click();
        } else if (perfil.equalsIgnoreCase("Para sua empresa")) {
            investment.getParaSuaEmpresaRadioButton().click();
        }

        investment.getValorAplicarTextField().sendKeys(aplicacao);
        investment.getValorInvestirTextField().sendKeys(poupanca);
        investment.getTempoInvestimentoTextField().sendKeys(tempo);

        investment.getTipoTempoDropDown().click();

        if (tipoTempo.equalsIgnoreCase("Meses")) {
            investment.getMesesButton().click();
        } else if (tipoTempo.equalsIgnoreCase("Anos")) {
            investment.getAnosButton().click();
        }
        ((JavascriptExecutor) browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", investment.getSimularButton());

        investment.getSimularButton().click();
    }
}
