package com.ultralesson.training.mobile.screens;

import com.ultralesson.training.mobile.models.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProfileSetupScreen extends MobileScreen{

   private By phoneNumber = By.xpath("//*[@text='id:phonenumber']");
   private By completeSetup = By.xpath("//*[@text='COMPLETE SETUP']");

    public ProfileSetupScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public HomeScreen completeSetup(User client) {
        actions.type(phoneNumber, client.getMobile());
        actions.click(completeSetup);
        return new HomeScreen(appiumDriver);
    }
}
