package End_to_end_tests.MeditationTests;

import Handlers.DriverHandler;
import Handlers.Factory;
import PageObject.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MeditationTest {
    @Before
    public void setUp(){
        DriverHandler.setUp();
    }
    @Test
    public void searchMeditationArticle() throws IOException {
        BasePage bp = Factory.BasePage();
        HomePage hp = Factory.HomePage();
        MeditationPage mp = Factory.MeditationPage();

        bp.login();
        hp.assertValidLogin();
        hp.openMeditationItem();
        mp.searchArticle();
        mp.clickArticleAndValidate();
    }
    @After
    public void tearDown(){
        DriverHandler.quitDriver();
    }
}
