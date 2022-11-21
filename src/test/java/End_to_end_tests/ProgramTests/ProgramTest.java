package End_to_end_tests.ProgramTests;

import Handlers.DriverHandler;
import Handlers.Factory;
import PageObject.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ProgramTest {
    @Before
    public void setUp(){
        DriverHandler.setUp();
    }
    @Test
    public void startProgram() throws IOException {
        BasePage bp = Factory.BasePage();
        HomePage hp = Factory.HomePage();
        ProgramsPage pp = Factory.ProgramsPage();

        bp.login();
        hp.assertValidLogin();
        hp.openProgramItem();
        pp.seeProgram(0);
    }
    @After
    public void tearDown(){
        DriverHandler.quitDriver();
    }
}
