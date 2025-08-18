package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverWaits;

import java.util.List;

public class AtletaPage {

    private WebDriver driver;
    private DriverWaits driverWaits;

    @FindBy(css = "img[alt='Rebeca ANDRADE']")
    private WebElement imgRebecaAndrade;
    @FindBy(css = ".search--results .list--item__athlete")
    private List<WebElement> listAtletas;
    @FindBy(css = "#input-search-athletes")
    private WebElement buscaAtleta;
    @FindBy(css = ".search-bar [data-cy='icon-search']")
    private WebElement buttonLupa;
    @FindBy(css = "img[alt='Novak DJOKOVIC']")
    private WebElement imgNovakDjokovic;

    public AtletaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driverWaits = new DriverWaits(driver);
    }

    public boolean validateQtdAtletas(int expectedQtd){
        driverWaits.waitElementAparecer(imgRebecaAndrade);
        return listAtletas.size() == expectedQtd;
    }

    public void buscarAtleta(String nomeAtleta){
        buscaAtleta.sendKeys(nomeAtleta);
        buttonLupa.click();
        driverWaits.waitElementAparecer(imgNovakDjokovic);
        imgNovakDjokovic.click();
    }

}
