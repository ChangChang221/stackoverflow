package com.stackoverflow.nhom24.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class UserResponse {
    private String id;
    private String name;
    private String username;
    private String password;
    private String photo;
    private String createdOn;
    private String role;
    private String location;
    private String badges;
    private String views;
    private String link;
    private String social;
    private List<String> tags;
    private Integer reputationScore;
    private Integer questions;
    private Integer answers;
}
