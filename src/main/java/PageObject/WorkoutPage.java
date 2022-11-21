package PageObject;

import Handlers.DriverHandler;
import Utilities.Constants;
import Utilities.ExcelUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WorkoutPage {
    @FindBy(how = How.CSS, using = "a[role=button]")
    private WebElement startWorkoutButton;
    @FindBy (how = How.XPATH, using = "//*[text()='Complete workout']")
    private WebElement completeWorkoutButton;
    @FindBy (how = How.XPATH, using = "//*[text()='Exit workout']")
    private WebElement exitWorkoutButton;
    @FindBy (how = How.CSS, using = "span[data-automation='morevert-icon']")
    private WebElement threedotButton;
    @FindBy (how = How.CSS, using = "button[type='button'] span[class='MuiButton-label']")
    private WebElement doneWorkoutButton;
    @FindAll(@FindBy(how = How.CSS, using = "button[data-ref='more-options-button']"))
    private List<WebElement> moreOptionsButtons;
    @FindBy(how = How.CSS, using = "input[placeholder='Search workouts']")
    private WebElement searchBar;
    @FindBy(how = How.CSS, using = "span[class='_Re8hi8S _2gqlliD']")
    private WebElement searchResult;
    @FindAll(@FindBy(how = How.CSS, using = "a[class='_28HkWHV']"))
    private List<WebElement> workouts;
    @FindBy(how = How.XPATH, using = "//*[text()='Confirm Swap']")
    private WebElement confirmSwapButton;
    @FindBy(how = How.XPATH, using = "//*[text()='Swap to Self-Guided workout']")
    private WebElement swapToGuidedWorkout;
    @FindBy(how = How.CSS, using = "h6[class='MuiTypography-root Typographystyles-sjta7b-0 jxeIQS MuiTypography-h6']")
    private WebElement workoutText;


    WebDriverWait wait = new WebDriverWait(DriverHandler.getDriver(), 10);

    static ExcelUtils excelUtils = new ExcelUtils();
    static String excelFilePath = Constants.Path_TestData+Constants.File_TestData;

    public void completeWorkout(){
        wait.until(ExpectedConditions.elementToBeClickable(startWorkoutButton));
        startWorkoutButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(threedotButton));
        threedotButton.click();
        /*wait.until(ExpectedConditions.elementToBeClickable(completeWorkoutButton));
        completeWorkoutButton.click();*/
        wait.until(ExpectedConditions.elementToBeClickable(exitWorkoutButton));
        exitWorkoutButton.click();
    }
    public void exitWorkout(){
        /*wait.until(ExpectedConditions.elementToBeClickable(doneWorkoutButton));
        doneWorkoutButton.click();*/
        wait.until(ExpectedConditions.urlToBe("https://centr.com/planner/0/2"));
        Assert.assertEquals("https://centr.com/planner/0/2", DriverHandler.getDriver().getCurrentUrl());
    }
    public void changeWorkout() throws IOException {
        excelUtils.setExcelFile(excelFilePath,"Sheet1");
        String query = excelUtils.getCellData(5, 1);
        wait.until(ExpectedConditions.elementToBeClickable(moreOptionsButtons.get(0)));
        moreOptionsButtons.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(swapToGuidedWorkout));
        swapToGuidedWorkout.click();
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(query + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(searchResult));
        Assert.assertEquals(query, searchResult.getText());
        wait.until(ExpectedConditions.visibilityOf(workouts.get(4)));
        String changedWorkout = workouts.get(4).getText();
        workouts.get(4).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmSwapButton));
        confirmSwapButton.click();
        wait.until(ExpectedConditions.urlToBe("https://centr.com/planner/0/2"));
        DriverHandler.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(workoutText));
        Assert.assertTrue(changedWorkout.equalsIgnoreCase(workoutText.getText()));


    }
}
