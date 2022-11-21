package End_to_end_tests;

import End_to_end_tests.LogOutTests.LogoutTest;
import End_to_end_tests.LoginTests.LoginTest;
import End_to_end_tests.MealTests.ShoppingListTest;
import End_to_end_tests.MealTests.SnackTest;
import End_to_end_tests.MeditationTests.MeditationTest;
import End_to_end_tests.ProgramTests.ProgramTest;
import End_to_end_tests.WorkoutTests.WorkoutTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        LoginTest.class,
        WorkoutTest.class,
        ShoppingListTest.class,
        SnackTest.class,
        MeditationTest.class,
        ProgramTest.class,
        LogoutTest.class
})

public class JUnitTestSuite {
}
