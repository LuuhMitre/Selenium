package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;
    
    @FindBy(linkText="Jogos Olímpicos")
    private WebElement buttonMenuJogosOlimpicos;
    @FindBy(linkText ="Atletas")
    private WebElement buttonMenuAtletas;
    
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

}
