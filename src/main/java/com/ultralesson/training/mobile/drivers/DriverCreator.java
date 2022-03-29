package com.ultralesson.training.mobile.drivers;

import com.ultralesson.training.mobile.data.mappers.DesiredCapabilitiesMapper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverCreator {

  private ThreadLocal<AppiumDriver> appiumDriverThreadLocal;
  private ThreadLocal<ServerManager> serverManagerThreadLocal;

  public DriverCreator() {
    appiumDriverThreadLocal = new ThreadLocal<>();
    serverManagerThreadLocal = new ThreadLocal<>();
    serverManagerThreadLocal.set(new ServerManager());
  }

  public AppiumDriver create() {
   DesiredCapabilities desiredCapabilities = new DesiredCapabilitiesMapper().map(System.getProperty("capabilies", "android"));
   return create(desiredCapabilities);
  }

  public AppiumDriver create(DesiredCapabilities desiredCapabilities) {
    Platform platform = desiredCapabilities.getPlatformName();
    DriverManager<AppiumDriver> mobileDriverManager = getDeviceManagers().get(platform);
    URL url = serverManagerThreadLocal.get().start();
    AppiumDriver appiumDriver =
        new MobileDriverContext(mobileDriverManager).create(url, desiredCapabilities);
    appiumDriverThreadLocal.set(appiumDriver);
    return appiumDriverThreadLocal.get();
  }


  public void destroy() {
    serverManagerThreadLocal.get().stop();
    appiumDriverThreadLocal.get().quit();
  }

  // Build a Device Managers Map
  public Map<Platform, DriverManager<AppiumDriver>> getDeviceManagers() {
    Map<Platform, DriverManager<AppiumDriver>> driverManagerMap = new HashMap<>();
    driverManagerMap.put(Platform.ANDROID, new AndroidDriverManager());
    driverManagerMap.put(Platform.IOS, new IOSDriverManager());
    return driverManagerMap;
  }
}
