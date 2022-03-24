package com.ultralesson.training.mobile.screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenActions {

    private AppiumDriver appiumDriver;
    private ScreenWaits waits;

    public ScreenActions(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.waits = new ScreenWaits(appiumDriver);
    }

    public void click(By by) {
        waits.waitForElementToBeVisible(by).click();
    }

    public void type(By by, String value) {
        waits.waitForElementToBeVisible(by).sendKeys(value);
    }

    public String getText(By by) {
        return waits.waitForElementToBeVisible(by).getText();
    }

    public void captureScreenshot(String screenshotname) {
        File screenshotAs = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshotAs.toPath(), new File("build/"+screenshotname+".png").toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
