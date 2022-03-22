package com.ultralesson.training.mobile.driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileDriverContext {

    private DriverManager<AppiumDriver> driverManager;

    public MobileDriverContext(DriverManager<AppiumDriver> driverManager) {
        setWebDriver(driverManager);
    }

    public AppiumDriver create(DesiredCapabilities desiredCapabilities) {
        return driverManager.create(desiredCapabilities);
    }

    public void setWebDriver(DriverManager<AppiumDriver> driverManager) {
        this.driverManager = driverManager;
    }
}
