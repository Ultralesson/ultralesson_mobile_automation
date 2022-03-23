package com.ultralesson.training.mobile.screens;

import com.ultralesson.training.mobile.models.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProfileScreen extends MobileScreen {


    // Avoid using xpaths. Ask development team to provide unique accessibility locators.

    private By email = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView");
    private By phoneNumber = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView");
    private By membershipStartDate = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.widget.TextView");
    public ProfileScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public User getProfileDetails() {
        User user = new User();
        user.setEmail(waits.waitForElementToBeVisible(email).getText());
        user.setMobile(waits.waitForElementToBeVisible(phoneNumber).getText());
        user.setMembershipStartDate(waits.waitForElementToBeVisible(membershipStartDate).getText());
        return user;
    }
}
