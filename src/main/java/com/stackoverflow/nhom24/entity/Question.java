package com.stackoverflow.nhom24.entity;

import com.stackoverflow.nhom24.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "question")
public class Question extends BaseEntity {
    private String title;
    private Integer userId;
    private String body;
    private Integer numberOfVote;
    private Date createdOn;
    private Integer views;
    private Boolean status;
}
