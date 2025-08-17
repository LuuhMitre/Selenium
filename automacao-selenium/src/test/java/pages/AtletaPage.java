package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverWaits;

public class AtletaPage {

    private WebDriver driver;
    private DriverWaits driverWaits;
    
    @FindBy(css = "img[alt='Rebeca ANDRADE']")
    private WebElement imgRebecaAndrade;
    @FindBy(css = ".search--results .list--item__athlete")
    private List<WebElement> listaAtletas;
    
    
    public AtletaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driverWaits = new DriverWaits(driver);
    }

    public boolean validateQtdAtletas(int expectedQtd){
        driverWaits.waitAtletaImagemAparecer(imgRebecaAndrade);
        return listaAtletas.size() == expectedQtd;
    }

}
