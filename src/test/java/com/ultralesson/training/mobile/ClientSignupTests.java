package com.ultralesson.training.mobile;

import com.ultralesson.training.mobile.driver.DriverCreator;
import com.ultralesson.training.mobile.models.User;
import com.ultralesson.training.mobile.screens.HomeScreen;
import com.ultralesson.training.mobile.screens.LauncherScreen;
import com.ultralesson.training.mobile.screens.ProfileScreen;
import com.ultralesson.training.mobile.screens.SignupScreen;
import com.ultralesson.training.mobile.utils.DateUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientSignupTests {

    @Test
    public void clientShouldBeAbleToSignupSuccessfully() {
        //Arrange
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "Google Pixel");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("app", "app/ul-coach.apk");

        AppiumDriver mobileDriver = new DriverCreator().createDriverContext(desiredCapabilities);

        LauncherScreen launcherScreen = new LauncherScreen(mobileDriver); // Assume mobileDriver is created and handy.
        launcherScreen.navToClientSignup();
        User client = new User("randomclient9@gmail.com",
                "password",
                "Client",
                "1234567890");

        //Act
        SignupScreen signupScreen = new SignupScreen(mobileDriver);
        HomeScreen homeScreen = signupScreen.signup(client).completeSetup(client);

        ProfileScreen profileScreen = homeScreen.navToProfile();
        User clientProfile = profileScreen.getProfileDetails();

        // Assert
        Assert.assertEquals(clientProfile.getEmail(), client.getEmail());
        Assert.assertEquals(clientProfile.getMobile(), client.getMobile());

        // Assume we have called a date utility to supply Today's Date
        Assert.assertEquals(clientProfile.getMembershipStartDate(), DateUtils.getTodayDate());

    }
}
