package com.stackoverflow.nhom24.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CommentResponse {
    private String id;
    private String userId;
    private String name;
    private String body;
    private String answerId;
    private String createdOn;
}
