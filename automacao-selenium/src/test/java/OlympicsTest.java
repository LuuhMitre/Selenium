
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class OlympicsTest {

    private WebDriver driver;

    @BeforeEach
    public void setup(){
        //configure driver
        driver = new ChromeDriver(); // Assuming ChromeDriver is used, import it accordingly
        driver.manage().window().maximize(); // Maximize the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit wait
        driver.get("https://www.olympics.com/pt"); // Navigate to the Olympics website
        driver.findElement(By.id("onetrust-accept-btn-handler")).click(); // Accept cookies
    
    }

    @Test 
    public void test(){
        WebElement menuJogos = driver.findElement(By.linkText("Jogos Olímpicos"));   
        menuJogos.click(); // Click on the "Jogos Olímpicos" menu item 
    }

    @AfterEach
    public void tearDown(){
        //close the driver
        if (driver != null) {
            driver.quit();
        }
    }
}
