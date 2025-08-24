package steps;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AtletaPage;
import pages.AtletaResultsPage;
import pages.JogosOlimpicosPage;
import pages.MainPage;
import utils.Driver;

import java.util.Map;

public class OlympicSteps {

    private WebDriver driverTest;

    @Before
    public void setup(){
        //configure driver
        Driver driver = new Driver();
        driverTest = driver.getChromeDriver();
        driverTest.get("https://www.olympics.com/pt");
        driverTest.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Given("I am on olympics page")
    public void iAmOnOlympicsPage() {
        MainPage mainPage = new MainPage(driverTest);
        mainPage.clickMenuJogosOlimpicos();
    }

    @Given("I am on athletes page")
    public void i_am_on_athletes_page() {
        MainPage mainPage = new MainPage(driverTest);
        mainPage.clickMenuAtletas();
    }

    @Given("I am on podcast page")
    public void iAmOnPodcastPage() throws InterruptedException {
        MainPage mainPage = new MainPage(driverTest);
        mainPage.clickMenuNoticias();
        mainPage.scrollToPodcastVerTudo();
    }

    @When("I search the athlete {string}")
    public void i_search_the_athlete(String name) {
        AtletaPage atletaPage = new AtletaPage(driverTest);
        atletaPage.buscarAtleta(name);
    }

    @When("I search the athlete")
    public void iSearchTheAthlete(Map<String,String> map) {
        AtletaPage atletaPage = new AtletaPage(driverTest);
        atletaPage.buscarAtleta(map.get("Athlete"));
    }

    @Then("the gold medal quantity should be {string}")
    public void the_gold_medal_quantity_should_be(String expectedQtd) {
        AtletaResultsPage atletaResultsPage = new AtletaResultsPage(driverTest);
        Assertions.assertEquals(expectedQtd, atletaResultsPage.getGoldMedals());
    }

    @Then("the quantity should be {int}")
    public void theQuantityShouldBe(int qtd) {
        AtletaPage atletaPage = new AtletaPage(driverTest);
        Assertions.assertTrue(atletaPage.validateQtdAtletas(qtd));
    }

    @Then("the title should be {string}")
    public void theTitleShouldBe(String title) {
        JogosOlimpicosPage jogosOlimpicosPage = new JogosOlimpicosPage(driverTest);
        Assertions.assertEquals(title, jogosOlimpicosPage.getTitleText().toLowerCase());
    }

    @Then("the spotify is available")
    public void the_spotify_is_available() {
        MainPage mainPage = new MainPage(driverTest);
        Assertions.assertTrue(mainPage.getSpotifyVisible());
    }

    @After
    public void tearDown(){
        driverTest.quit();
    }

}
