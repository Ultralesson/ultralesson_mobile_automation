package com.ultralesson.training.mobile.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AndroidDriverManager implements DriverManager<AppiumDriver> {
    @Override
    public AppiumDriver create(URL serverUrl, DesiredCapabilities desiredCapabilities) {
        return new AndroidDriver(serverUrl, desiredCapabilities);
    }
}
