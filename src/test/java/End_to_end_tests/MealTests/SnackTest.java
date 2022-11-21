package End_to_end_tests.MealTests;

import Handlers.DriverHandler;
import Handlers.Factory;
import PageObject.BasePage;
import PageObject.HomePage;
import PageObject.ShoppingListPage;
import PageObject.SnacksPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SnackTest {
    @Before
    public void setUp(){
        DriverHandler.setUp();
    }
    @Test
    public void addSnackToShoppingList() throws IOException {
        BasePage bp = Factory.BasePage();
        HomePage hp = Factory.HomePage();
        SnacksPage sp = Factory.SnacksPage();
        ShoppingListPage shoppingListPage = Factory.ShoppingListpage();

        bp.login();
        hp.assertValidLogin();
        hp.openSnacksList();
        sp.searchSnack(0);
        sp.addSnackToList();
        sp.goToShoppingList();
        shoppingListPage.clearSnacksList();
    }
    @Test
    public void searchDietarySnack() throws IOException {
        BasePage bp = Factory.BasePage();
        HomePage hp = Factory.HomePage();
        SnacksPage sp = Factory.SnacksPage();

        bp.login();
        hp.assertValidLogin();
        hp.openSnacksList();
        sp.searchDietary();
        sp.searchChef();
        sp.assertSearch(2);
    }
    @After
    public void tearDown(){
        DriverHandler.quitDriver();
    }
}
