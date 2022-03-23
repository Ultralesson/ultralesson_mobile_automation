package com.ultralesson.training.mobile.screens;

import com.ultralesson.training.mobile.models.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SignupScreen extends MobileScreen {


    // The signup screen contains several elements that will be represented as MobileElements.
    // The locators for these elements should be defined only once.
    By email = By.xpath("//*[@text='id:email']");
    By password = By.xpath("//*[@text='id:password']");
    By fullName = By.xpath("//*[@text='id:fullname']");
    By signupBtn = By.xpath("//*[@text='SIGNUP']");

    public SignupScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


//    // The signup screen page allows the user to type email, password, fullname
    public ProfileSetupScreen signup(User client) {
        actions.type(email, client.getEmail());
        actions.type(password, client.getPassword());
        actions.type(fullName, client.getFullName());
        actions.click(signupBtn);

        // Return the HomeScreen as it navigates to HomeScreen on clicking signup.
        return new ProfileSetupScreen(appiumDriver);
    }

}