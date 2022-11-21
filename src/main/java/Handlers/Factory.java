package Handlers;

import PageObject.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class Factory {
    public static BasePage BasePage(){
        BasePage basePage = new BasePage();
        PageFactory.initElements(DriverHandler.driver, basePage);
        return basePage;
    }
    public static HomePage HomePage(){
        HomePage homePage = new HomePage();
        PageFactory.initElements(DriverHandler.driver, homePage);
        return homePage;
    }
    public static WorkoutPage WorkoutPage(){
        WorkoutPage workoutPage = new WorkoutPage();
        PageFactory.initElements(DriverHandler.driver, workoutPage);
        return workoutPage;
    }
    public static ShoppingListPage ShoppingListpage(){
        ShoppingListPage shoppingListPage = new ShoppingListPage();
        PageFactory.initElements(DriverHandler.driver, shoppingListPage);
        return shoppingListPage;
    }
    public static SnacksPage SnacksPage(){
        SnacksPage snacksPage = new SnacksPage();
        PageFactory.initElements(DriverHandler.driver, snacksPage);
        return snacksPage;
    }
    public static MeditationPage MeditationPage(){
        MeditationPage meditationPage = new MeditationPage();
        PageFactory.initElements(DriverHandler.driver, meditationPage);
        return meditationPage;
    }
    public static ProgramsPage ProgramsPage(){
        ProgramsPage programsPage = new ProgramsPage();
        PageFactory.initElements(DriverHandler.driver, programsPage);
        return programsPage;
    }
    public static SettingsPage SettingsPage(){
        SettingsPage settingsPage = new SettingsPage();
        PageFactory.initElements(DriverHandler.driver, settingsPage);
        return settingsPage;
    }
}
