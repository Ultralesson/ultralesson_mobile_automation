package com.ultralesson.training.mobile.drivers;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;

import static org.awaitility.Awaitility.await;

public class ServerManager {

  protected final ThreadLocal<AppiumDriverLocalService> appiumDriverLocalServiceThreadLocal;

  public ServerManager() {
    this.appiumDriverLocalServiceThreadLocal = new ThreadLocal<>();
    build();
  }

  private void build() {
    AppiumServiceBuilder appiumServiceBuilder =
        new AppiumServiceBuilder()
            .usingAnyFreePort();
    appiumDriverLocalServiceThreadLocal.set(AppiumDriverLocalService.buildService(appiumServiceBuilder));
  }

  public URL start() {
    appiumDriverLocalServiceThreadLocal.get().start();
    await().atMost(Duration.ofSeconds(10)).until(appiumDriverLocalServiceThreadLocal.get()::isRunning);
    return appiumDriverLocalServiceThreadLocal.get().getUrl();
  }

  public void stop() {
    appiumDriverLocalServiceThreadLocal.get().stop();
  }

  private Integer getRandomPort() {
    try (ServerSocket socket = new ServerSocket(0)) {
      return socket.getLocalPort();
    } catch (IOException e) {
      throw new RuntimeException("No open ports available to start Appium service");
    }
  }
}
