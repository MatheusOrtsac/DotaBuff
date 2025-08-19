package page;

import dotabuffprojeto.DriveFactory;
import dotabuffprojeto.NamesHerois;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.PageHelper;

import javax.naming.Name;
import java.util.List;

public class ListaHerois {
    @FindBy(xpath = "//div [@class = 'tw-space-y-2 tw-p-1']")
    public WebElement txtHerois;
    @FindBy(className = "name")
    public List<WebElement> namelist;

    public ListaHerois() {
        PageFactory.initElements(DriveFactory.getInstance().getDriver(), this);
    }

    public void clicarHeroi(List<NamesHerois> listaHerois) {
        PageHelper.waitUntilVisibility(txtHerois, "txtHerois");

        for (WebElement name : namelist) {
            boolean clicou = false;
            for (NamesHerois heroi : listaHerois) {
                if (name.getText().toLowerCase().contains(heroi.getNome().toLowerCase())) {
                    name.click();
                    clicou = true;
                    break;
                }
            }
            if(clicou){
                break;
            }
        }
    }
}
