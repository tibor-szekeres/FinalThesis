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
    @FindAll(@FindBy(how = How.CSS, using = "div[data-automation='accordion-container']"))
    private List<WebElement> shoppingListDays;
    @FindBy(how = How.CSS, using = "a[id='create-shoppinglist-btn']")
    private WebElement createShoppingListBtn;
    @FindBy(how = How.CSS, using = "a[class='_2mbgYzQ _1eH793T _3rw_7Wj']")
    private WebElement createNewListBtn;
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
    @FindBy(how = How.CSS, using = "svg[id='create-shoppinglist-icon']")
    private WebElement createNewShoppingListBtn;

    private final WebDriverWait wait = new WebDriverWait(DriverHandler.getDriver(), 10);

    static ExcelUtils excelUtils = new ExcelUtils();
    static String excelFilePath = Constants.Path_TestData+Constants.File_TestData;

    public void createList(int day){
        wait.until(ExpectedConditions.elementToBeClickable(createNewShoppingListBtn));
        createNewShoppingListBtn.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(shoppingListDays));
        shoppingListDays.get(day).click();
        wait.until(ExpectedConditions.elementToBeClickable(createShoppingListBtn));
        createShoppingListBtn.click();
        try{
            wait.until(ExpectedConditions.elementToBeClickable(createNewListBtn));
            createNewListBtn.click();

            wait.until(ExpectedConditions.elementToBeClickable(clearListBtn));
            clearListBtn.click();
        } catch (Exception e){
            wait.until(ExpectedConditions.elementToBeClickable(clearListBtn));
            clearListBtn.click();
        }

    }
    public void clearList() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(clearButtons));
        clearButtons.click();

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
