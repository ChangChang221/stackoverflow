package com.stackoverflow.nhom24.model.response;

import com.stackoverflow.nhom24.entity.User;
import com.stackoverflow.nhom24.entity.Vote;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class AnswerResponse {
    private String id;
    private ObjectId userId;
    private String body;
    private Date createOn;
    private ObjectId questionId;
    private List<Vote> votes;
    private Integer score;
    private User user;
}
