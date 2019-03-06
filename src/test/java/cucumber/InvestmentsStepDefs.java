package cucumber;

import browser.Browser;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pageObjects.ErrorsPageObjects;
import pageObjects.InvestmentSimulationPageObjects;
import pageObjects.ResultSimultionPageObjects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InvestmentsStepDefs {
    private Browser browser;
    private InvestmentSimulationPageObjects investment;
    private ResultSimultionPageObjects results;
    private ErrorsPageObjects errors;

    public InvestmentsStepDefs() {
        this.browser = new Browser();
        investment = new InvestmentSimulationPageObjects(browser.getDriver());
        results = new ResultSimultionPageObjects(browser.getDriver());
        errors = new ErrorsPageObjects(browser.getDriver());
    }

    @Before
    public void setUp() {
        this.browser.getDriver().get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
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
    public void queiraDefinirOValorDeAplicacao(String aplicacao) {
        investment.getValorAplicarTextField().sendKeys(aplicacao);
    }

    @E("queira poupar por mês {string} Reais por {string} {string}")
    public void queiraPouparPorMesPorMeses(String valor, String tempo, String tipoTempo) {
        investment.getValorInvestirTextField().sendKeys(valor);
        investment.getTempoInvestimentoTextField().sendKeys(tempo);
        investment.getTipoTempoDropDown().click();

        if (tipoTempo.equalsIgnoreCase("Meses")) {
            investment.getMesesButton().click();
        } else if (tipoTempo.equalsIgnoreCase("Anos")) {
            investment.getAnosButton().click();
        }
    }

    @Quando("eu pressionar o botão Simular")
    public void euPressionarOBotaoSimulator() {
        investment.getSimularButton().click();
    }


    @Então("a simulação ira mostrar o valor esperado de {string} Reais poupados")
    public void aSimulacaoIraMostrarOValorEsperadoDeReaisPoupados(String valorEsperado) {

        ((JavascriptExecutor) browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", results.getSavingsValueInvestmentLabel());
        new Actions(browser.getDriver()).moveToElement(results.getSavingsValueInvestmentLabel()).perform();
        assertTrue(results.getSavingsValueInvestmentLabel().getAttribute("innerText").contains(valorEsperado));
    }

    @Entao("eu vou visualizar a mensagem de erro {string} e a mensagem de erro {string}")
    public void euVouVisualizarAMensagemDeErroEAMensagemDeErro(String mensagem, String mensagem2) {
        assertTrue(
                errors.getValorAplicarErrorLabel().getAttribute("innerText").contains(mensagem) &&
                        errors.getValorInvestirErrorLabel().getAttribute("innerText").contains(mensagem) &&
                        errors.getTempoErrorLabel().getAttribute("innerText").contains(mensagem2)
        );
    }

    @After
    public void tearDown() {
        this.browser.quit();
    }


}

