package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JogosOlimpicosPage {

    private WebDriver driver;

    public JogosOlimpicosPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By textPageTitle = By.cssSelector("[data-cy='distributive-header'] h1");

    public String getTitleText(){
        return driver.findElement(textPageTitle).getText();
    }

}
