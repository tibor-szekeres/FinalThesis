package PageObject;

import Handlers.DriverHandler;
import Utilities.Constants;
import Utilities.ExcelUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class BasePage {
    @FindBy(how = How.CSS, using = "form > p")
    private WebElement errorLoginString;
    @FindBy (how = How.CSS, using = "a[id='CybotCookiebotDialogBodyButtonAccept']")
    private WebElement cookieAcceptButton;
    @FindBy (how = How.CSS, using = "[data-automation='loginButton']")
    private WebElement loginButton;
    @FindBy (how = How.CSS, using = "[type='email']")
    private WebElement email;
    @FindBy (how = How.CSS, using = "[type='password']")
    private WebElement password;
    @FindBy (how = How.CSS, using = "[data-automation='signinButton']")
    private WebElement signInButton;

    private final WebDriverWait wait = new WebDriverWait(DriverHandler.getDriver(), 10);

    static ExcelUtils excelUtils = new ExcelUtils();
    static String excelFilePath = Constants.Path_TestData+Constants.File_TestData;

    public void fullyLoadPage(){
        new WebDriverWait(DriverHandler.getDriver(), 5).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void login() throws IOException {
        fullyLoadPage();

        if(DriverHandler.getDriver().getCurrentUrl().equals("https://centr.com/centr")){
           DriverHandler.getDriver().get("https://centr.com/join-us");
           fullyLoadPage();
        }
        wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
        cookieAcceptButton.click();
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(email));
        excelUtils.setExcelFile(excelFilePath,"Sheet1");
        email.sendKeys(excelUtils.getCellData(1,1));
        password.sendKeys(excelUtils.getCellData(1,2));
        signInButton.click();
    }
    public void invalidLogin() throws IOException {
        fullyLoadPage();

        if(DriverHandler.getDriver().getCurrentUrl().equals("https://centr.com/centr")){
            DriverHandler.getDriver().get("https://centr.com/join-us");
            fullyLoadPage();
        }
        wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
        cookieAcceptButton.click();
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(email));
        excelUtils.setExcelFile(excelFilePath,"Sheet1");
        email.sendKeys(excelUtils.getCellData(2,1));
        password.sendKeys(excelUtils.getCellData(2,2));
        signInButton.click();
    }
    public void assertInvalidLogin() throws IOException {
        excelUtils.setExcelFile(excelFilePath,"Sheet1");
        wait.until(ExpectedConditions.visibilityOf(errorLoginString));
        Assert.assertEquals(excelUtils.getCellData(6, 1), errorLoginString.getText());
    }
}
