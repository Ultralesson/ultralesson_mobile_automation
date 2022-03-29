package com.ultralesson.training.mobile;

import com.ultralesson.training.mobile.drivers.DriverCreator;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseMobileTest {

    private ThreadLocal<DriverCreator> driverCreatorThreadLocal;
    private ThreadLocal<AppiumDriver> appiumDriverThreadLocal;

    public BaseMobileTest() {
        driverCreatorThreadLocal = new ThreadLocal<>();
        appiumDriverThreadLocal = new ThreadLocal<>();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driverCreatorThreadLocal.set(new DriverCreator());
        appiumDriverThreadLocal.set(driverCreatorThreadLocal.get().create());
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driverCreatorThreadLocal.get().destroy();
    }

    protected AppiumDriver getDriver() {
        return appiumDriverThreadLocal.get();
    }
}
