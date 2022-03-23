package com.ultralesson.training.mobile.drivers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class MobileDriverContext {

    private DriverManager<AppiumDriver> driverManager;

    public MobileDriverContext(DriverManager<AppiumDriver> driverManager) {
        setWebDriver(driverManager);
    }

    public AppiumDriver create(URL serverUrl, DesiredCapabilities desiredCapabilities) {
        return driverManager.create(serverUrl, desiredCapabilities);
    }

    public void setWebDriver(DriverManager<AppiumDriver> driverManager) {
        this.driverManager = driverManager;
    }
}
