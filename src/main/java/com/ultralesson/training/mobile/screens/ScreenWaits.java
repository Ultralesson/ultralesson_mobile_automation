package com.ultralesson.training.mobile.screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class ScreenWaits {

    private AppiumDriver appiumDriver;
    private FluentWait<AppiumDriver> wait;

    public ScreenWaits(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.wait = initWait(appiumDriver);
    }

    public WebElement waitForElementToBeVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> waitForAllElementsToBeVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    private FluentWait<AppiumDriver> initWait(AppiumDriver appiumDriver) {
        return new FluentWait<>(appiumDriver)
                .withTimeout(Duration.ofSeconds(90))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);


    }
}
