package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContainerObject {

    @Getter @FindBy(css = "[data-cy='megamenu-news-container']")
    private WebElement newsContainer;
    @Getter @FindBy(css = "[data-cy='podcast-module']")
    private WebElement podcastModule;

    public ContainerObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
