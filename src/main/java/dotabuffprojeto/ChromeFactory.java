package dotabuffprojeto;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFactory {
    public ChromeDriver abrirGoogleChrome() {
        ChromeDriver chromeDriver = new ChromeDriver(setChromeOptions());
        return chromeDriver;
    }

    private ChromeOptions setChromeOptions() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;

    }
}

