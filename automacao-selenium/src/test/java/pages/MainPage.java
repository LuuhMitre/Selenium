package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By buttonMenuJogosOlimpicos = By.linkText("Jogos Olímpicos");
    private final By buttonMenuAtletas = By.linkText("Atletas");

    public void clickMenuJogosOlimpicos(){
        driver.findElement(buttonMenuJogosOlimpicos).click();
    }

    public void clickMenuAtletas(){
        driver.findElement(buttonMenuAtletas).click();
    }

}
