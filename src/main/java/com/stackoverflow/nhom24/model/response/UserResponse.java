package com.stackoverflow.nhom24.model.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {
    private Integer id;
    private String name;
    private String username;
    private String photo;
    private String location;
    private Integer views;
    private Integer answers;
    private  Integer questions;
    private String link;
    private String social;
}
