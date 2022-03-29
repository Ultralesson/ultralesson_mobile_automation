package com.ultralesson.training.mobile.drivers;

import com.testvagrant.ekam.devicemanager.devicefinder.LocalDeviceFinder;
import com.testvagrant.ekam.devicemanager.models.DeviceFilters;
import com.testvagrant.ekam.devicemanager.models.TargetDetails;
import com.ultralesson.training.mobile.data.mappers.DesiredCapabilitiesMapper;
import com.ultralesson.training.mobile.data.mappers.DeviceFiltersMapper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Capabilities;
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
    // Read default capabilities from the json
   DesiredCapabilities desiredCapabilities = new DesiredCapabilitiesMapper()
           .map(System.getProperty("capabilies", "android"));

   //Read Device Filters
    DeviceFilters deviceFilters = new DeviceFiltersMapper()
            .map(System.getProperty("filters", "top_used"));

   // Find an available device matching the platform and filters
    TargetDetails device = new LocalDeviceFinder(desiredCapabilities.getPlatformName().name(),
            deviceFilters).findDevice();

    // Create new capabilities based on the device identified
    DesiredCapabilities updatedCapabilities = new DesiredCapabilities(device.asMap());

    //Merge default capabilities with the updated capabilities
    desiredCapabilities.merge(updatedCapabilities);

    //Create a session
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
