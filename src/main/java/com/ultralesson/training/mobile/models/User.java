package com.ultralesson.training.mobile.models;


import com.ultralesson.training.mobile.utils.DateUtils;
import lombok.*;
import org.assertj.core.api.Assertions;

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

    public void assertThatUserProfileIsValid(User that) {
        Assertions.assertThat(this.email).isEqualTo(that.email);
        Assertions.assertThat(this.mobile).isEqualTo(that.mobile);
        Assertions.assertThat(that.membershipStartDate).isEqualTo(DateUtils.getTodayDate());
    }
}
