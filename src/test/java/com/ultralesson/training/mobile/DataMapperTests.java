package com.ultralesson.training.mobile;

import com.ultralesson.training.mobile.data.clients.UserDataClient;
import com.ultralesson.training.mobile.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataMapperTests {

//    @Test(testName = "Verify that client with pending assignments is sourced correctly.")
    public void verifyThatClientWithPendingAssignmentstIsSourcedCorrectly() {
        UserDataClient userDataClient = new UserDataClient();
        User clientWithPendingAssignments = userDataClient
                .getValidClient("clientWithPendingAssignments");

        Assert.assertEquals(clientWithPendingAssignments.getEmail(), "client1@gmail.com");
        Assert.assertEquals(clientWithPendingAssignments.getPassword(), "password");
    }

//    @Test(testName = "Verify that client with no assignments is sourced correctly.")
    public void verifyThatCustomerWithNoAssignmentsIsSourcedCorrectly() {
        UserDataClient userDataClient = new UserDataClient();
        User clientWithNoAssignments = userDataClient
                .getValidClient("clientWithNoAssignments");

        Assert.assertEquals(clientWithNoAssignments.getEmail(), "client2@gmail.com");
        Assert.assertEquals(clientWithNoAssignments.getPassword(), "password");
    }
}
