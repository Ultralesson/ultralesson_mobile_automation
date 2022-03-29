package com.ultralesson.training.mobile.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Note {
    private String title;
    private String body;

    public Note init() {
        return Note.builder()
                .title("Note Title")
                .body("Note Body")
                .build();
    }
}
