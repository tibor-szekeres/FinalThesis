package PageObject;

import Handlers.DriverHandler;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {
    @FindBy(how = How.XPATH, using = "//*[text()='Log out']")
    private WebElement logoutBtn;

    WebDriverWait wait = new WebDriverWait(DriverHandler.getDriver(), 10);

    public void logOut(){
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        logoutBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://centr.com/"));
        Assert.assertEquals("https://centr.com/" , DriverHandler.getDriver().getCurrentUrl());
    }
}
