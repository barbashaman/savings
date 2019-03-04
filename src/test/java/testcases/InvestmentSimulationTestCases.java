package testcases;

import browser.Browser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import tasks.ErrorsTasks;
import tasks.InvestmentsTasks;
import tasks.ResultSimulationTasks;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("InvestmentsSimulation")
public class InvestmentSimulationTestCases {
    private Browser browser;
    private InvestmentsTasks investments;
    private ResultSimulationTasks resultSimulation;
    private ErrorsTasks errors;

    @BeforeEach
    public void SetUp(){
        browser = new Browser();
        investments = new InvestmentsTasks(browser);
        resultSimulation = new ResultSimulationTasks(browser);
        errors = new ErrorsTasks(browser);
    }

    @Tag("HappyPath")
    @ParameterizedTest(name = "{index} => {0}, {6}")
    @CsvFileSource(resources = {"/csv/savings.csv"}, numLinesToSkip = 1)
    public void savingsInvestmentSuccessfulTest(ArgumentsAccessor argumentsAccessor) {
        this.browser.getDriver().get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");

        investments.makeInvestment(
                argumentsAccessor.getString(1),
                argumentsAccessor.getString(2),
                argumentsAccessor.getString(3),
                argumentsAccessor.getString(4),
                argumentsAccessor.getString(5)
        );

        assertTrue(resultSimulation.isTimeCorrect(argumentsAccessor.getString(4), argumentsAccessor.getString(5)));
        assertTrue(resultSimulation.isValueCorrect(argumentsAccessor.getString(6)));
    }

    @Tag("WrongValues")
    @ParameterizedTest(name = "{index} => {0}, {6}")
    @CsvFileSource(resources = {"/csv/fail.csv"}, numLinesToSkip = 1)
    public void savingsInvestmentFailTest(ArgumentsAccessor argumentsAccessor) {
        this.browser.getDriver().get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
        investments.makeInvestment(
                argumentsAccessor.getString(1),
                argumentsAccessor.getString(2),
                argumentsAccessor.getString(3),
                argumentsAccessor.getString(4),
                argumentsAccessor.getString(5)
        );

        assertTrue(errors.isApplicationErrorEnabled(argumentsAccessor.getString(6)));
        assertTrue(errors.isSavingsErrorEnabled(argumentsAccessor.getString(6)));
        assertTrue(errors.isTempoErrorEnabled(argumentsAccessor.getString(7)));
    }

    @AfterEach
    public void tearDown(){
        this.browser.quit();
    }
}
