package com.ultralesson.training.mobile.driver;

import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriverManager<Driver> {

    /**
     * Create a new driver
     * @return
     */
    Driver create(DesiredCapabilities desiredCapabilities);
}
