package com.ultralesson.training.mobile.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IOSDriverManager implements DriverManager<AppiumDriver> {
    @Override
    public AppiumDriver create(DesiredCapabilities desiredCapabilities) {
        return new IOSDriver(desiredCapabilities);
    }
}
