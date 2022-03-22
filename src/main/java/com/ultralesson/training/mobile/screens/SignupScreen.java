package com.ultralesson.training.mobile.screens;

import com.ultralesson.training.mobile.models.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SignupScreen {

    private AppiumDriver appiumDriver;

    // The signup screen contains several elements that will be represented as MobileElements.
    // The locators for these elements should be defined only once.
    By email = By.xpath("//*[@text()='id:email']");
    By password = By.xpath("//*[@text()='id:password']");
    By fullName = By.xpath("//*[@text()='id:fullname']");
    By signupBtn = By.xpath("//*[@text='SIGNUP']");

    public SignupScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }


//    // The signup screen page allows the user to type email, password, fullname
    public HomeScreen signup(User client) {
        appiumDriver.findElement(email).sendKeys(client.getEmail());
        appiumDriver.findElement(password).sendKeys(client.getPassword());
        appiumDriver.findElement(fullName).sendKeys(client.getFullName());
        appiumDriver.findElement(signupBtn).click();

        // Return the HomeScreen as it navigates to HomeScreen on clicking signup.
        return new HomeScreen(appiumDriver);
    }

}