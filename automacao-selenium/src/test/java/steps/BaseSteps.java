package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class BaseSteps {

    public static WebDriver driverTest;

    @Before
    public void setup(){
        //configure driver
        Driver driver = new Driver();
        driverTest = driver.getChromeDriver();
        driverTest.get("https://www.olympics.com/pt");
        driverTest.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @After
    public void tearDown(){
        driverTest.quit();
    }
}
