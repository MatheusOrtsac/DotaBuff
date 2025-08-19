package page;

import dotabuffprojeto.DriveFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver = DriveFactory.getInstance().getDriver();
    public static final String URL_PADRAO = "https://pt.dotabuff.com/";

    @FindBy(xpath = "//a[contains(@data-target, 'heroes')]")
    public WebElement inputBtheroi;
    @FindBy(xpath = "//a[@href='/heroes'][contains(.,'Todos os heróis')]")
    public WebElement inputBtallheroi;


    public BasePage() {
        PageFactory.initElements(driver, this);
        driver.get(URL_PADRAO);

//    }
        inputBtheroi.click();
        }
    }


