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


public class MeditationPage {
    @FindBy(how = How.CSS, using = "input[placeholder='Search meditations']")
    private WebElement searchBar;
    @FindBy(how = How.CSS, using = "[placeholder='Search meditations']")
    private WebElement searchResult;
    @FindBy(how = How.CSS, using = "[data-automation='item-0']")
    private WebElement meditationArticle;
    @FindBy(how = How.CSS, using = "h1[class='MuiTypography-root Typographystyles-sjta7b-0 gOdMQi MuiTypography-h4']")
    private WebElement articleTitle;

    WebDriverWait wait = new WebDriverWait(DriverHandler.getDriver(), 8);

    static ExcelUtils excelUtils = new ExcelUtils();
    static String excelFilePath = Constants.Path_TestData+Constants.File_TestData;

    public void searchArticle() throws IOException {
        excelUtils.setExcelFile(excelFilePath,"Sheet1");
        String query = excelUtils.getCellData(4, 1);
        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        searchBar.sendKeys(query);
        wait.until(ExpectedConditions.visibilityOf(searchResult));
        Assert.assertEquals(query, searchResult.getAttribute("value"));
    }

    public void clickArticleAndValidate() throws IOException {
        DriverHandler.getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(meditationArticle));
        meditationArticle.click();
        meditationArticle.click();
        excelUtils.setExcelFile(excelFilePath,"Sheet1");
        wait.until(ExpectedConditions.urlContains(excelUtils.getCellData(7, 1)));
        Assert.assertTrue(DriverHandler.getDriver().getCurrentUrl().contains(excelUtils.getCellData(7, 1)));
    }
}
