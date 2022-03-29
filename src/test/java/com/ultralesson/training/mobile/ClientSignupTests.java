package com.ultralesson.training.mobile;

import com.ultralesson.training.mobile.drivers.DriverCreator;
import com.ultralesson.training.mobile.models.User;
import com.ultralesson.training.mobile.screens.HomeScreen;
import com.ultralesson.training.mobile.screens.LauncherScreen;
import com.ultralesson.training.mobile.screens.ProfileScreen;
import com.ultralesson.training.mobile.screens.SignupScreen;
import com.ultralesson.training.mobile.utils.DateUtils;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.*;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Signup")
@Feature("Client Signup")
public class ClientSignupTests {

    @Test(groups = "mobile")
    @Story("Verify that client is able to signup successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clientShouldBeAbleToSignupSuccessfully() {
        //Arrange
        DriverCreator driverCreator = new DriverCreator();
        AppiumDriver mobileDriver = driverCreator.create();

        LauncherScreen launcherScreen = new LauncherScreen(mobileDriver); // Assume mobileDriver is created and handy.
        launcherScreen.navToClientSignup();
        User client = User.builder().build().initClient();

        //Act
        SignupScreen signupScreen = new SignupScreen(mobileDriver);
        HomeScreen homeScreen = signupScreen.signup(client).completeSetup(client);

        ProfileScreen profileScreen = homeScreen.navToProfile();
        User clientProfile = profileScreen.getProfileDetails();

        // Assert
        client.assertThatUserProfileIsValid(clientProfile);
    }
}
