package cucumber;

import browser.Browser;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pageObjects.InvestmentSimulationPageObjects;
import pageObjects.ResultSimultionPageObjects;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InvestmentsStepDefs {
    private Browser browser;
    private InvestmentSimulationPageObjects investment;
    private ResultSimultionPageObjects results;

    public InvestmentsStepDefs() {
        this.browser = new Browser();
        investment = new InvestmentSimulationPageObjects(browser.getDriver());
        results = new ResultSimultionPageObjects(browser.getDriver());
        this.browser.getDriver().get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
    }


    @E("queira poupar por mês {string} Reais por {string} {string}")
    public void queiraPouparPorMêsPorMeses(String valor, String tempo, String tipoTempo) {
        investment.getValorInvestirTextField().sendKeys(valor);
        investment.getTempoInvestimentoTextField().sendKeys(tempo);
        investment.getTipoTempoDropDown().click();
        if (tipoTempo.equalsIgnoreCase("Meses")) {
            investment.getMesesButton().click();
        } else if (tipoTempo.equalsIgnoreCase("Anos")) {
            investment.getAnosButton().click();
        }
    }

    @Dado("que eu tenha um usuario do Sicredi com o perfil {string}")
    public void queEuTenhaUmUsuarioDoSicrediComOPerfil(String perfil) {
        if (perfil.equalsIgnoreCase("Para você")) {
            investment.getParaVoceRadioButton().click();
        } else if (perfil.equalsIgnoreCase("Para sua empresa")) {
            investment.getParaSuaEmpresaRadioButton().click();
        }
    }

    @E("queira definir o valor de aplicação {string}")
    public void queiraDefinirOValorDeAplicação(String aplicacao) {
        investment.getValorAplicarTextField().sendKeys(aplicacao);
    }

    @Quando("eu pressionar o botão Simular")
    public void euPressionarOBotãoSimulator() {
        ((JavascriptExecutor) browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", investment.getSimularButton());
        investment.getSimularButton().click();
    }


    @Então("a simulação ira mostrar o valor esperado de {string} Reais poupados")
    public void aSimulaçãoIraMostrarOValorEsperadoDeReaisPoupados(String valorEsperado) {
        browser.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        new Actions(browser.getDriver()).moveToElement(results.getSavingsValueInvestmentLabel()).perform();
        boolean isValorEsperadoCorreto = results.getSavingsValueInvestmentLabel().getAttribute("innerText").contains(valorEsperado);
        assertTrue(isValorEsperadoCorreto);
    }
}

