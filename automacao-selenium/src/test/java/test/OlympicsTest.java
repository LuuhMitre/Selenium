package test;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.JogosOlimpicosPage;
import pages.MainPage;

public class OlympicsTest {

    private WebDriver driver;

    @BeforeEach
    public void setup(){
     //configure driver
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get("https://www.olympics.com/pt");
     driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Test
    public void validateJogosOlimpicosPage(){

        MainPage mainPage = new MainPage(driver);
        mainPage.clickMenuJogosOlimpicos();

        JogosOlimpicosPage jogosOlimpicosPage = new JogosOlimpicosPage(driver);
        Assertions.assertEquals("jogos olímpicos", jogosOlimpicosPage.getTitleText().toLowerCase());
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
