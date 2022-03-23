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
        waits.waitForElementToBeVisible(profile).click();
        return new ProfileScreen(appiumDriver);
    }

    public ProfileScreen navToAssignments() {
        waits.waitForElementToBeVisible(assignments).click();
        return new ProfileScreen(appiumDriver);
    }

    public ProfileScreen navToNotes() {
        waits.waitForElementToBeVisible(notes).click();
        return new ProfileScreen(appiumDriver);
    }

    public ProfileScreen navToResources() {
        waits.waitForElementToBeVisible(resources).click();
        return new ProfileScreen(appiumDriver);
    }
}
