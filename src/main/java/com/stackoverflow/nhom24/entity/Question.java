package com.stackoverflow.nhom24.entity;

import com.stackoverflow.nhom24.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@Document(collection = "question")
public class Question extends BaseEntity {
    private String title;
    private Integer userId;
    private String body;
    private Integer numberOfVote;
    private Date createdOn;
    private Integer views;
    private Boolean status;
}
