package page;

import dotabuffprojeto.DriveFactory;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.PageHelper;

import java.io.File;
import java.util.List;

public class ListaItens {
    @FindBy(xpath = "//tr[@data-link-to]//img[@data-tooltip-url]")
    public List<WebElement> itenslist;
    @FindBy(xpath = "/html/body/div[2]/div[7]/div[3]/div[4]/div[1]/div[1]/section[5]/article/table")
    public WebElement tabelaToda;
    @FindBy(xpath = "//header[contains(.,'Itens mais usadosEsta semana mais')]")
    public WebElement txtItens;

    public ListaItens() {
        PageFactory.initElements(DriveFactory.getInstance().getDriver(), this);
    }

    public byte[] tirarPrintItens() {
        PageHelper.waitUntilVisibility(txtItens, "txtItens");
        try {
            File screenshot = tabelaToda.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("c:/images/teste_item_tabelaToda.jpeg"));
            return tabelaToda.getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            System.out.println("deu ruim" + e);
            return null;
        }
    }
}

