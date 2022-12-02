package PageObject;

import Handlers.DriverHandler;
import Utilities.Constants;
import Utilities.ExcelUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class ShoppingListPage {
    @FindAll(@FindBy(how = How.XPATH, using = "//*[text()='Add full week']"))
    private WebElement addFullWeek;
    @FindBy(how = How.CSS, using = "//*[text()='Create new shopping list']")
    private WebElement createShoppingListBtn;

    @FindBy(how = How.CSS, using = "data-automation='clear-all-btn'")
    private WebElement clearWholeListBtn;
    @FindBy(how = How.CSS, using = "button[id='clear-list-btn']")
    private WebElement clearListBtn;
    @FindBy(how = How.CSS, using = "button[class='_2mbgYzQ _3Z6a-M7 _3rw_7Wj']")
    private WebElement clearButtons;
    @FindBy(how = How.CSS, using = "div[id='shoppinglist-empty-title']")
    private WebElement emptyTitle;
    @FindBy(how = How.ID, using = "Layer_1")
    private WebElement header;
    @FindBy(how = How.CSS, using = "h1[data-automation='header-title']")
    private WebElement headerTitle;
    @FindBy(how = How.XPATH, using = "//*[text()='Create new shopping list']")
    private WebElement createNewShoppingListBtn;

    private final WebDriverWait wait = new WebDriverWait(DriverHandler.getDriver(), 10);

    static ExcelUtils excelUtils = new ExcelUtils();
    static String excelFilePath = Constants.Path_TestData+Constants.File_TestData;

    public void createList(int day){
        wait.until(ExpectedConditions.elementToBeClickable(createNewShoppingListBtn));
        createNewShoppingListBtn.click();
        wait.until(ExpectedConditions.visibilityOf(addFullWeek));
        addFullWeek.click();
        wait.until(ExpectedConditions.elementToBeClickable(createNewShoppingListBtn));
        createNewShoppingListBtn.click();

    }
    public void clearList() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(clearListBtn));
        clearListBtn.click();

        excelUtils.setExcelFile(excelFilePath,"Sheet1");
        wait.until(ExpectedConditions.visibilityOf(emptyTitle));
        Assert.assertEquals(excelUtils.getCellData(9, 1), emptyTitle.getText());

        wait.until(ExpectedConditions.elementToBeClickable(header));
        header.click();
    }
    public void clearSnacksList() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(clearListBtn));
        clearListBtn.click();

        clearList();
    }
}
