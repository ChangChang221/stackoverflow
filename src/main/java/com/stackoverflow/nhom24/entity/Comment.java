package com.stackoverflow.nhom24.entity;

import com.stackoverflow.nhom24.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Setter
@Getter
@Document(collection = "comment")
public class Comment extends BaseEntity {
    private Integer userId;
    private String name;
    private String body;
    private Integer answerId;
    private Date createdOn;
}
