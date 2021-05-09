package com.stackoverflow.nhom24.model.response;

import com.stackoverflow.nhom24.entity.Tag;
import com.stackoverflow.nhom24.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class QuestionResponse {
    private String id;
    private String title;
    private String userId;
    private String body;
    private Date createdOn;
    private List<TagResponse> tags;
    private Integer views;
    private Integer answer;
    private User user;
}
