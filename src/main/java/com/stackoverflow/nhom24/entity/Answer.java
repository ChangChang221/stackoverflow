package com.stackoverflow.nhom24.entity;

import com.stackoverflow.nhom24.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import com.stackoverflow.nhom24.entity.Vote;
@Setter
@Getter
@Document(collection = "answer")
public class Answer extends BaseEntity {
    private ObjectId userId;
    private String body;
    private Date createOn;
    private ObjectId questionId;
    private List<Vote> votes;
    private Integer score;

    public void addVote(Vote vote){
        this.votes.add(vote);
    }
}
