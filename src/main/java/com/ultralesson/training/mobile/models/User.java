package com.ultralesson.training.mobile.models;


import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)
public class User {
    private String email;
    private String password;
    private String fullName;
    private String mobile;
    private String membershipStartDate;

    public User initClient() {
        return User.builder()
                .email("automationclient@gmai.com")
                .password("password")
                .fullName("Automation Client")
                .mobile("1234567890")
                .build();

    }
}
