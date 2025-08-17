package utils;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWaits {

    WebDriver driver;
    WebDriverWait wait;

    public DriverWaits(WebDriver driver) {
        this.driver = driver;    
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void waitAtletaImagemAparecer(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
