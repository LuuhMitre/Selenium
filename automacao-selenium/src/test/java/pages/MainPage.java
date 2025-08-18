package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverWaits;

import java.time.Duration;
import java.util.List;

public class MainPage {

    private WebDriver driver;
    private DriverWaits driverWaits;

    @FindBy(linkText = "Jogos Olímpicos")
    private WebElement buttonMenuJogosOlimpicos;
    @FindBy(linkText = "Atletas")
    private WebElement buttonMenuAtletas;
    @FindBy(linkText = "Notícias")
    private WebElement buttonMenuNoticias;
    @FindBy(css = "img[alt='Rebeca ANDRADE']")
    private WebElement imgRebecaAndrade;
    @FindBy(css = ".search--results .list--item__athlete")
    private List<WebElement> listAtletas;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driverWaits = new DriverWaits(driver);
    }

    public void clickMenuJogosOlimpicos(){
        buttonMenuJogosOlimpicos.click();
    }

    public void clickMenuAtletas(){
        buttonMenuAtletas.click();
    }

    public void clickMenuNoticias(){
        buttonMenuNoticias.click();
    }

    public void moveElementToNoticas(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonMenuNoticias);
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonMenuJogosOlimpicos).pause(Duration.ofSeconds(2)).perform();
        actions.moveToElement(buttonMenuNoticias).pause(Duration.ofSeconds(2)).perform();
        ContainerObject containerObject = new ContainerObject(driver);
        driverWaits.waitElementAparecer(containerObject.getNewsContainer());
        containerObject.getPodcastModule().findElement(By.linkText("Veja todos")).click();
    }
}
