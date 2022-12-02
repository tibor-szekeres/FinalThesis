package End_to_end_tests.WorkoutTests;

import Handlers.DriverHandler;
import Handlers.Factory;
import PageObject.BasePage;
import PageObject.HomePage;
import PageObject.WorkoutPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class WorkoutTest {
    @Before
    public void setUp(){
        DriverHandler.setUp();
    }
    //@Test
//    public void startFinishWorkout() throws IOException {
//        BasePage bp = Factory.BasePage();
//        HomePage hp = Factory.HomePage();
//        WorkoutPage wp = Factory.WorkoutPage();
//
//        bp.login();
//        hp.assertValidLogin();
//        hp.selectTuesday();
//        hp.openWorkout();
//        wp.completeWorkout();
//        wp.exitWorkout();
//    }
    @Test
    public void changeWorkout() throws IOException, InterruptedException {
        BasePage bp = Factory.BasePage();
        HomePage hp = Factory.HomePage();
        WorkoutPage wp = Factory.WorkoutPage();

        bp.login();
        hp.assertValidLogin();
        hp.selectTuesday();
        wp.changeWorkout();
    }
    @After
    public void tearDown(){
        DriverHandler.quitDriver();
    }
}
