package com.ultralesson.training.mobile.screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LauncherScreen extends MobileScreen {

    By createClientAccountBtn = By.xpath("//*[@text='CREATE CLIENT ACCOUNT']");
    By createCoachAccountBtn = By.xpath("//*[@text='CREATE COACH ACCOUNT']");
    By loginBtn = By.xpath("//*[@text='Log In']");

    public LauncherScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public SignupScreen navToClientSignup() {
        waits.waitForElementToBeVisible(createClientAccountBtn).click();
        return new SignupScreen(appiumDriver);
    }

    public SignupScreen navToCoachSignup() {
        waits.waitForElementToBeVisible(createCoachAccountBtn).click();
        return new SignupScreen(appiumDriver);
    }

    public SignupScreen navToLogin() {
        waits.waitForElementToBeVisible(loginBtn).click();
        return new SignupScreen(appiumDriver);
    }
}
