package util;

import dotabuffprojeto.DriveFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PageHelper {
    public static byte[] Takescreenshot(){
        TakesScreenshot screenshot = ((TakesScreenshot) DriveFactory.getInstance().getDriver());
        File printscren = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            String caminhoProjeto = "./target/evidencias/";
            String nomeDinamico = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss"))+ ".jpeg";
            FileUtils.copyFile(printscren, new File (caminhoProjeto + nomeDinamico));
        }catch (Exception e) {
            throw new IllegalStateException("não foi possivel tirar print");
        }
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }

    public static WebElement waitUntilVisibility(WebElement element, String descricao) {
        try{
            getFluentWait().until(ExpectedConditions.visibilityOf(element));
            return element;
        }catch(Exception e){
            throw new ElementNotInteractableException("Error, Não foi possivel executar Motivo:" + descricao + e.getMessage());
        }
    }

    private static FluentWait getFluentWait(){
        return new FluentWait(DriveFactory.getInstance().getDriver())
                .withTimeout(Duration.ofSeconds(8))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementNotInteractableException.class);
    }
}

