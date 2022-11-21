package End_to_end_tests.LogOutTests;

import Handlers.DriverHandler;
import Handlers.Factory;
import PageObject.BasePage;
import PageObject.HomePage;
import PageObject.SettingsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LogoutTest {
    @Before
    public void setUp(){
        DriverHandler.setUp();
    }
    @Test
    public void logOut() throws IOException {
        BasePage bp = Factory.BasePage();
        HomePage hp = Factory.HomePage();
        SettingsPage sp = Factory.SettingsPage();
        bp.login();
        hp.assertValidLogin();
        hp.openMenuItem();
        sp.logOut();
    }
    @After
    public void tearDown(){
        DriverHandler.quitDriver();
    }
}
