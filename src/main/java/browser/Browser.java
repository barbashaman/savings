package browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

    private WebDriver driver;

    public Browser(){
        ChromeDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        this.driver = new ChromeDriver(options);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quit(){
        this.getDriver().close();
        this.getDriver().quit();
    }
}
