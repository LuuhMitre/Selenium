package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.AtletaPage;
import pages.JogosOlimpicosPage;
import pages.MainPage;
import utils.Driver;

public class OlympicsTest {

    private WebDriver driverTest;

    @BeforeEach
    public void setup(){
     //configure driver
        Driver driver = new Driver();
        driverTest = driver.getChromeDriver();
        driverTest.get("https://www.olympics.com/pt");
        driverTest.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Test
    public void validateJogosOlimpicosPage(){

        MainPage mainPage = new MainPage(driverTest);
        mainPage.clickMenuJogosOlimpicos();

        JogosOlimpicosPage jogosOlimpicosPage = new JogosOlimpicosPage(driverTest);
        Assertions.assertEquals("jogos olímpicos", jogosOlimpicosPage.getTitleText().toLowerCase());
    }

    @Test
    public void validateAtleta(){
        MainPage mainPage = new MainPage(driverTest);
        mainPage.clickMenuAtletas();
        AtletaPage atletaPage = new AtletaPage(driverTest);
        Assertions.assertTrue(atletaPage.validateQtdAtletas(24));
    }

    @AfterEach
    public void tearDown(){
        driverTest.quit();
    }

}
