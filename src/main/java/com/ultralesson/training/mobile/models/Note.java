package com.ultralesson.training.mobile.models;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Note extends Model {
    private String title;
    private String body;

    public Note init() {
        return Note.builder()
                .title(faker.letterify("Title: ?????????"))
                .body(faker.lorem().paragraph())
                .build();
    }
}
