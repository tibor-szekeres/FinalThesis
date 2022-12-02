package PageObject;

import Handlers.DriverHandler;
import org.apache.commons.math3.analysis.function.Exp;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    @FindBy(how = How.CSS, using = "button[class='Modalstyles__CloseButton-sslm0d-1 wChjp']")
    private WebElement closeModalButton;
    @FindBy(how = How.CSS, using = "button[aria-label='Close Message']")
    private WebElement closeMessageButton;
    @FindBy (how = How.CSS, using = "div[class='MuiBox-root jss48']")
    private WebElement popUpWindow;
    @FindBy (how = How.CSS, using = "button[index='29']")
    private WebElement tuesdaySelector;
    @FindAll(@FindBy (how = How.CSS, using = "div[data-testid='progressWrapper']"))
    private List<WebElement> workoutProgresses;
    @FindBy (how = How.XPATH, using = "//*[text()='Shopping List']")
    private WebElement shoppingListButton;
    @FindBy (how = How.XPATH, using = "//*[text()='Snacks']")
    private WebElement snacksButton;
    @FindBy(how = How.CSS, using = "span[data-automation='menu-icon']")
    private WebElement menuButton;
    @FindBy(how = How.XPATH, using = "//*[text()='Meditations & Sleep']")
    private WebElement meditationBtn;
    @FindBy(how = How.XPATH, using = "//*[text()='Programs']")
    private WebElement programBtn;
    @FindBy(how = How.XPATH, using = "//*[text()='Settings']")
    private WebElement settingsBtn;
    @FindBy(how = How.CSS, using = "[data-automation='plannerContentGroupTitle']")
    private WebElement plannerGroup;

    WebDriverWait wait = new WebDriverWait(DriverHandler.getDriver(), 10);

    public void assertValidLogin(){
        wait.until(ExpectedConditions.visibilityOf(plannerGroup));
        //closeMessageButton.click();
        Assert.assertTrue(plannerGroup.isDisplayed());
    }
    public void selectTuesday(){
        wait.until(ExpectedConditions.elementToBeClickable(tuesdaySelector));
        tuesdaySelector.click();
    }
    public void openWorkout(){
        wait.until(ExpectedConditions.visibilityOf(workoutProgresses.get(0)));
        workoutProgresses.get(0).click();
    }
    public void openShoppingList(){
        openMenuItem();
        wait.until(ExpectedConditions.elementToBeClickable(shoppingListButton));
        shoppingListButton.click();
    }
    public void openSnacksList(){
        openMenuItem();
        wait.until(ExpectedConditions.elementToBeClickable(snacksButton));
        snacksButton.click();
    }
    public void openMeditationItem(){
        openMenuItem();
        wait.until(ExpectedConditions.elementToBeClickable(meditationBtn));
        meditationBtn.click();
    }
    public void openProgramItem(){
        openMenuItem();
        wait.until(ExpectedConditions.elementToBeClickable(programBtn));
        programBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://centr.com/programs"));
    }
    public void openMenuItem(){
        wait.until(ExpectedConditions.elementToBeClickable(menuButton));
        menuButton.click();
    }
    public void openSettings(){
        openMenuItem();
        wait.until(ExpectedConditions.elementToBeClickable(settingsBtn));
        settingsBtn.click();
    }
}
