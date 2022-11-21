package End_to_end_tests.MealTests;

import Handlers.DriverHandler;
import Handlers.Factory;
import PageObject.BasePage;
import PageObject.HomePage;
import PageObject.ShoppingListPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ShoppingListTest {
    @Before
    public void setUp(){
        DriverHandler.setUp();
    }
    @Test
    public void addFoodToShoppingList() throws IOException {
        BasePage bp = Factory.BasePage();
        HomePage hp = Factory.HomePage();
        ShoppingListPage sp = Factory.ShoppingListpage();

        bp.login();
        hp.assertValidLogin();
        hp.openShoppingList();
        sp.createList(0);
        sp.clearList();
    }
    @After
    public void tearDown(){
        DriverHandler.quitDriver();
    }
}
