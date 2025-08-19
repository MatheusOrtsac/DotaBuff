package dotabuffprojeto;

import org.openqa.selenium.WebDriver;

public class DriveFactory {
    private static DriveFactory instancia = null;
    private WebDriver driver = null;

    public static DriveFactory getInstance() {
        if (instancia == null) {
            instancia = new DriveFactory();
        }
        return instancia;
    }

    public void setDriver(DriverType driverType) {
        if(driverType.equals(DriverType.CHROME)) {
            ChromeFactory chromeFactory = new ChromeFactory();
            driver = chromeFactory.abrirGoogleChrome();
        }
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void quitDrive(){
        if (driver != null) {
        driver.quit();
    }
 }

}