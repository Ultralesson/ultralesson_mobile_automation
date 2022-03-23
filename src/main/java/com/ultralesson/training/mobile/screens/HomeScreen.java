package com.ultralesson.training.mobile.screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomeScreen extends MobileScreen {


    private By assignments = By.xpath("//*[@text='Assignments']");
    private By notes = By.xpath("//*[@text='Notes']");
    private By resources = By.xpath("//*[@text='Resources']");
    private By profile = By.xpath("//*[@text='Profile']");


    public HomeScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public ProfileScreen navToProfile() {
        actions.click(profile);
        return new ProfileScreen(appiumDriver);
    }

    public ProfileScreen navToAssignments() {
        actions.click(assignments);
        return new ProfileScreen(appiumDriver);
    }

    public ProfileScreen navToNotes() {
        actions.click(notes);
        return new ProfileScreen(appiumDriver);
    }

    public ProfileScreen navToResources() {
        actions.click(resources);
        return new ProfileScreen(appiumDriver);
    }
}
