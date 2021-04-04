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
@Table(name = "answer")
public class Answer extends BaseEntity {
    private Integer userId;
    private String body;
    private Date createOn;
    private Integer questionId;
}
