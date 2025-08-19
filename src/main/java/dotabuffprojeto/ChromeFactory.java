//package dotabuffprojeto;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//public class ChromeFactory {
//    public ChromeDriver abrirGoogleChrome() {
//        ChromeDriver chromeDriver = new ChromeDriver(setChromeOptions());
//        return chromeDriver;
//    }
//
//    private ChromeOptions setChromeOptions() {
//        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("start-maximized");
//        return chromeOptions;
//
//    }
//}

package dotabuffprojeto;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFactory {
    public ChromeDriver abrirGoogleChrome() {
        // WebDriverManager cuida de configurar o ChromeDriver automaticamente
        WebDriverManager.chromedriver().driverVersion("139.0.7258.128").setup();


        // Agora cria o ChromeDriver com as opções configuradas
        ChromeDriver chromeDriver = new ChromeDriver(setChromeOptions());
        return chromeDriver;
    }

    private ChromeOptions setChromeOptions() {
        // Não é mais necessário configurar o caminho do driver manualmente
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }
}
