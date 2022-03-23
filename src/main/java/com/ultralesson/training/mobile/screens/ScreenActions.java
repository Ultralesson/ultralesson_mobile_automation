package com.ultralesson.training.mobile.screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ScreenActions {

    private AppiumDriver appiumDriver;
    private ScreenWaits waits;

    public ScreenActions(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.waits = new ScreenWaits(appiumDriver);
    }

    public void click(By by) {
        waits.waitForElementToBeVisible(by).click();
    }

    public void type(By by, String value) {
        waits.waitForElementToBeVisible(by).sendKeys(value);
    }

    public String getText(By by) {
        return waits.waitForElementToBeVisible(by).getText();
    }
}
