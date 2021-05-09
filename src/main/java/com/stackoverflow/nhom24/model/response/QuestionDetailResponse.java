package com.stackoverflow.nhom24.model.response;

import com.stackoverflow.nhom24.entity.Answer;
import com.stackoverflow.nhom24.entity.Tag;
import com.stackoverflow.nhom24.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class QuestionDetailResponse {
    private String id;
    private String title;
    private String userId;
    private String body;
    private Date createdOn;
    private List<Tag> tags;
    private Integer views;
    private List<Answer> answers;
    private User user;
}
