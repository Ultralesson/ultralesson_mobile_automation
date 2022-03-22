package com.ultralesson.training.mobile.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidDriverManager implements DriverManager<AppiumDriver> {
    @Override
    public AppiumDriver create(DesiredCapabilities desiredCapabilities) {
        return new AndroidDriver(desiredCapabilities);
    }
}
