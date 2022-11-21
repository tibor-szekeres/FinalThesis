package End_to_end_tests.LoginTests;

import Handlers.DriverHandler;
import Handlers.Factory;
import PageObject.BasePage;
import PageObject.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoginTest {
    @Before
    public void setUp(){
        DriverHandler.setUp();
    }
    @Test
    public void validLogin() throws IOException {
        BasePage bp = Factory.BasePage();
        HomePage hp = Factory.HomePage();
        bp.login();
        hp.assertValidLogin();
    }
    @Test
    public void invalidLogin() throws IOException {
        BasePage bp = Factory.BasePage();
        bp.invalidLogin();
        bp.assertInvalidLogin();
    }
    @After
    public void tearDown(){
        DriverHandler.quitDriver();
    }
}
