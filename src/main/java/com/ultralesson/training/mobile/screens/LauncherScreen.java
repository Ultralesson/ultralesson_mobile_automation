package com.ultralesson.training.mobile.screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LauncherScreen {

    private AppiumDriver appiumDriver;

    By createClientAccountBtn = By.xpath("//*[@text='CREATE CLIENT ACCOUNT']");
    By createCoachAccountBtn = By.xpath("//*[@text='CREATE COACH ACCOUNT']");
    By loginBtn = By.xpath("//*[@text='Log In']");

    public LauncherScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public SignupScreen navToClientSignup() {
        appiumDriver.findElement(createClientAccountBtn).click();
        return new SignupScreen(appiumDriver);
    }

    public SignupScreen navToCoachSignup() {
        appiumDriver.findElement(createCoachAccountBtn).click();
        return new SignupScreen(appiumDriver);
    }

    public SignupScreen navToLogin() {
        appiumDriver.findElement(loginBtn).click();
        return new SignupScreen(appiumDriver);
    }
}
