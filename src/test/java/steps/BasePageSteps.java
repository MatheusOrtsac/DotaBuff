package steps;

import dotabuffprojeto.DriveFactory;
import dotabuffprojeto.NamesHerois;
import dotabuffprojeto.NomesItens;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import org.apache.maven.shared.utils.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.BasePage;
import page.ListaHerois;
import page.ListaItens;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasePageSteps {

    BasePage basePage = new BasePage();
    private List<NamesHerois> listDeHerois = new ArrayList<>();

    @Dado("logar no site com sucesso")
    public void fazerLoginComSucesso() {
        Assert.assertEquals("Estatísticas de facetas de heróis - DOTABUFF - Dota 2 Stats", DriveFactory.getInstance().getDriver().getTitle());
    }

    @Dado("acesssar selecao de herois")
    public void acesssarSelecaoDeHerois() {
        basePage.inputBtheroi.click();
        Assert.assertEquals("https://pt.dotabuff.com/heroes", DriveFactory.getInstance().getDriver().getCurrentUrl());
    }

    @Então("selecionar o heroi para obter os dados")
    public void selecionarOHeroiParaObterOsDados(io.cucumber.datatable.DataTable dataTable) {
        for (Map<String, String> map : dataTable.asMaps()) {
            NamesHerois namesHerois = new NamesHerois(map.get("herois"));
            listDeHerois.add(namesHerois);
        }
        ListaHerois listaHerois = new ListaHerois();
        listaHerois.clicarHeroi(listDeHerois);
        String nomeHeroi = listDeHerois.get(0).getNome().toLowerCase().replace(" ", "-");
        String url = "https://pt.dotabuff.com/heroes/" + nomeHeroi;
        Assert.assertEquals(url, DriveFactory.getInstance().getDriver().getCurrentUrl());

    }

    @Dado("dos primeiros itens mais usados")
    public void dosPrimeirosItensMaisUsados() {
        ListaItens listaItens = new ListaItens();
        Hooks.currentScenario.attach(listaItens.tirarPrintItens(), "image/png", "evidencia");

    }
}