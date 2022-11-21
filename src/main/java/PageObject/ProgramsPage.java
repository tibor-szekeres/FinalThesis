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
import java.util.concurrent.TimeUnit;

public class ProgramsPage {
    @FindAll(@FindBy(how = How.CSS, using = "h5[data-automation='title']"))
    private List<WebElement> programsList;
    @FindBy(how = How.CSS, using = "span[class='StickyHeaderstyles__Summary-sc-1e8rw6b-2 eRSOxM']")
    private WebElement title;

    WebDriverWait wait = new WebDriverWait(DriverHandler.getDriver(), 5);
    static ExcelUtils excelUtils = new ExcelUtils();
    static String excelFilePath = Constants.Path_TestData+Constants.File_TestData;

    public void seeProgram(int nthItem) throws IOException {
        DriverHandler.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        programsList.get(nthItem).click();
        wait.until(ExpectedConditions.visibilityOf(title));
        excelUtils.setExcelFile(excelFilePath,"Sheet1");
        Assert.assertTrue(title.getText().contains(excelUtils.getCellData(8, 1)));
    }
}
