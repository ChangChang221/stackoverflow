package com.stackoverflow.nhom24.entity;

import com.stackoverflow.nhom24.entity.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Document(collection = "user")
@NoArgsConstructor
public class User extends BaseEntity {
    private String name;
    private String username;
    private String password;
    private String photo;
    private Date createdOn;
    private String role;
    private String location;
    private String badges;
    private Integer views;
    private String link;
    private String social;
    private List<String> tags;
    private Integer reputationScore;
    private Integer questions;
    private Integer answers;
}
