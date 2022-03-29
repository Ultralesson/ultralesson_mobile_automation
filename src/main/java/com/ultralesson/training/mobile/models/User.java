package com.ultralesson.training.mobile.models;


import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data @NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)
public class User extends Model {
    private String email;
    private String password;
    private String fullName;
    private String mobile;
    private String membershipStartDate;

    public User initClient() {
        return User.builder()
                .email(faker.internet().emailAddress())
                .password("password")
                .fullName(faker.name().fullName())
                .mobile(faker.numerify("##########"))
                .build();

    }
}
