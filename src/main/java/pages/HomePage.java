package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @FindBy(xpath = "//span[text()='Electronics']")
    private WebElement electronicsMenu;

    @FindBy(xpath = "//div[@class='_1fwVde']//a") 
    private List<WebElement> subMenuItems;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public void hoverOverElectronics() {
        actions.moveToElement(electronicsMenu).perform();
    }

    public void printSubMenus() {
        wait.until(ExpectedConditions.visibilityOfAllElements(subMenuItems));
        for (WebElement menuItem : subMenuItems) {
            System.out.println(menuItem.getText());
        }
    }
}
