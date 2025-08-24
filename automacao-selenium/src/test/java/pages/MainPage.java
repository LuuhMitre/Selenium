package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverWaits;

import java.util.List;

public class MainPage {

    private WebDriver driver;

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
    @FindBy(css = "[data-cy='news-card']")
    private WebElement newsCard;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public void scrollToPodcastVerTudo () {
        WebElement cardPodcast = driver.findElement(By.cssSelector("img[alt='Seleção feminina chega fortalecida à Copa América']"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(cardPodcast).perform();
        driver.findElement(By.cssSelector("a[href='https://olympics.com/pt/podcast/']")).click();
    }

    public boolean getSpotifyVisible(){
        return driver.findElement(By.cssSelector("img[src='/images/static/podcast/spotify-logo.svg']")).isDisplayed();
    }

}
