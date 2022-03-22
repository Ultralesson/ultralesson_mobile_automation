package com.ultralesson.training.mobile.screens;

import io.appium.java_client.AppiumDriver;

public class HomeScreen {

    private AppiumDriver appiumDriver;

    public HomeScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public ProfileScreen navToProfile() {
        return new ProfileScreen(appiumDriver);
    }
}
