package com.ultralesson.training.mobile.drivers;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public interface DriverManager<Driver> {

    /**
     * Create a new driver
     * @return
     */
    Driver create(URL serverURL, DesiredCapabilities desiredCapabilities);
}
