package com.ultralesson.training.mobile;

import com.ultralesson.training.mobile.models.User;
import com.ultralesson.training.mobile.screens.HomeScreen;
import com.ultralesson.training.mobile.screens.LauncherScreen;
import com.ultralesson.training.mobile.screens.ProfileScreen;
import com.ultralesson.training.mobile.screens.SignupScreen;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Signup")
@Feature("Client Signup")
public class ClientSignupTestsCopy2 extends BaseMobileTest {

    @Test(groups = "mobile")
    @Story("Verify that client is able to signup successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void clientShouldBeAbleToSignupSuccessfullyCopy1() {
        //Arrange
        LauncherScreen launcherScreen = new LauncherScreen(getDriver()); // Assume mobileDriver is created and handy.
        launcherScreen.navToClientSignup();
        User client = User.builder().build().initClient();

        //Act
        SignupScreen signupScreen = new SignupScreen(getDriver());
        HomeScreen homeScreen = signupScreen.signup(client).completeSetup(client);

        ProfileScreen profileScreen = homeScreen.navToProfile();
        User clientProfile = profileScreen.getProfileDetails();

        // Assert
        client.assertThatUserProfileIsValid(clientProfile);
    }
}
