package PageObject;

import Handlers.DriverHandler;
import Handlers.Factory;
import Utilities.Constants;
import Utilities.ExcelUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.DocFlavor;
import java.io.IOException;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SnacksPage {
    @FindBy(how = How.CSS, using = "input[placeholder='Search snacks']")
    private WebElement searchBar;
    @FindBy(how = How.CSS, using = "span[class='_Re8hi8S _2gqlliD']")
    private WebElement searchResult;
    @FindBy(how = How.CSS, using = "h2[class='_YuQgFPB']")
    private List<WebElement> searchedSnacks;
    @FindBy(how = How.CSS, using = "a[data-automation='addToShoppingListBtn']")
    private WebElement addToList;
    @FindAll(@FindBy(how = How.CSS, using = "span[data-automation='menu-icon']"))
    private List<WebElement> menuButtons;
    @FindBy(how = How.XPATH, using = "//*[text()='Shopping List']")
    private WebElement shoppingListBtn;
    @FindBy(how = How.CSS, using = "button[data-automation='Dietary']")
    private WebElement dietaryButton;
    @FindBy(how = How.CSS, using = "button[data-automation='Chef']")
    private WebElement chefButton;
    @FindBy(how = How.CSS, using = "label[data-automation='dietary-dairy free']")
    private WebElement dietarySelect;
    @FindBy(how = How.CSS, using = "label[data-automation='chef-luke zocchi']")
    private WebElement chefSelect;
    @FindAll(@FindBy(how = How.CSS, using = "a[data-automation='title-text']"))
    private List<WebElement> titleTexts;
    @FindBy(how = How.CSS, using = "div[style='position: fixed; inset: 0px; z-index: 10; background-color: transparent;']")
    private WebElement webPage;
    @FindBy(how = How.CSS, using = "circle[id='Oval']")
    private WebElement searchIcon;

    private final WebDriverWait wait = new WebDriverWait(DriverHandler.getDriver(), 5);

    static ExcelUtils excelUtils = new ExcelUtils();
    static String excelFilePath = Constants.Path_TestData+Constants.File_TestData;

    public void searchSnack(int snackNr) throws IOException {

        excelUtils.setExcelFile(excelFilePath,"Sheet1");
        String snack = excelUtils.getCellData(3, 1);

        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        searchBar.sendKeys(snack + Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOf(searchResult));
        Assert.assertEquals(snack, searchResult.getText());

        DriverHandler.getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(searchedSnacks.get(snackNr)));
        searchedSnacks.get(snackNr).click();
    }

    public void addSnackToList() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(addToList));
        addToList.click();
        excelUtils.setExcelFile(excelFilePath,"Sheet1");
        wait.until(ExpectedConditions.visibilityOf(addToList));
        Assert.assertEquals(excelUtils.getCellData(10, 1), addToList.getText());
    }
    public void goToShoppingList(){
        DriverHandler.getDriver().navigate().refresh();
        DriverHandler.getDriver().manage().window().maximize();
        DriverHandler.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        BasePage bp = new BasePage();
        bp.fullyLoadPage();
        wait.until(ExpectedConditions.visibilityOf(menuButtons.get(0)));
        menuButtons.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(shoppingListBtn));
        shoppingListBtn.click();
        /*HomePage hp = new HomePage();
        hp.openShoppingList();*/
    }
    public void searchDietary(){
        wait.until(ExpectedConditions.elementToBeClickable(dietaryButton));
        dietaryButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(dietarySelect));
        dietarySelect.click();
        webPage.click();
    }

    public void searchChef(){
        wait.until(ExpectedConditions.elementToBeClickable(chefButton));
        chefButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(chefSelect));
        chefSelect.click();
        webPage.click();
    }
    public void assertSearch(int nthItem) throws IOException {
        excelUtils.setExcelFile(excelFilePath,"Sheet1");
        DriverHandler.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(titleTexts.get(nthItem)));
        Assert.assertEquals(excelUtils.getCellData(11, 1), titleTexts.get(nthItem).getText());
    }
}
