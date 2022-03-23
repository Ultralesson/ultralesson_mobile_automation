package com.ultralesson.training.mobile.screens;

import io.appium.java_client.AppiumDriver;

public abstract class MobileScreen {
    protected AppiumDriver appiumDriver;
    protected ScreenWaits waits;

    public MobileScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.waits = new ScreenWaits(appiumDriver);
    }
}
