package com.stackoverflow.nhom24.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class AnswerResponse {
    private String id;
    private String userId;
    private String body;
    private String createdOn;
    private String questionId;
    private List<String> votes;
    private Integer score;
}
