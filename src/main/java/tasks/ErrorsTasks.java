package tasks;

import browser.Browser;
import pageObjects.ErrorsPageObjects;

public class ErrorsTasks {
    Browser browser;
    ErrorsPageObjects errors;

    public ErrorsTasks(Browser browser) {
        this.browser = browser;
        this.errors = new ErrorsPageObjects(browser.getDriver());
    }

    public boolean isApplicationErrorEnabled(String errorMessage) {
        return errors.getValorAplicarErrorLabel().isEnabled() && errors.getValorAplicarErrorLabel().getAttribute("innerText").contains(errorMessage);
    }

    public boolean isSavingsErrorEnabled(String errorMessage) {
        return errors.getValorInvestirErrorLabel().isEnabled() && errors.getValorInvestirErrorLabel().getAttribute("innerText").contains(errorMessage);
    }

    public boolean isTempoErrorEnabled(String errorMessage) {
        return errors.getTempoErrorLabel().isEnabled() && errors.getTempoErrorLabel().getAttribute("innerText").contains(errorMessage);
    }
}
