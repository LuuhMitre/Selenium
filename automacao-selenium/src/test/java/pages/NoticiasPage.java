package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NoticiasPage {

    private final WebDriver driver;

    @FindBy(css = "img[src='/images/static/podcast/spotify-logo.svg'")
    private WebElement iconSpotify;
    @FindBy(css = "img[alt='Seleção feminina chega fortalecida à Copa América']")
    private WebElement cardPodcast;
    @FindBy(css = "a[href='https://olympics.com/pt/podcast/']")
    private WebElement buttonVejaTudo;


    public NoticiasPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scrollToPodcastVerTudo () {
        Actions actions = new Actions(driver);
        actions.scrollToElement(cardPodcast).perform();
        buttonVejaTudo.click();
    }

    public boolean getSpotifyVisible(){
        return iconSpotify.isDisplayed();
    }

}
