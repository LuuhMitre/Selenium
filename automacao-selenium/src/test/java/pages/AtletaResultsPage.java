package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverWaits;

public class AtletaResultsPage {

    @FindBy(css = "[title='Ouro'] span[data-cy='medal-main']")
    private WebElement goldMedal;

    public AtletaResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getGoldMedals(){
        return goldMedal.getText();
    }

}
