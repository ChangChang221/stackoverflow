package com.stackoverflow.nhom24.model.response;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Setter
@Getter
public class UserResponse {
    private ObjectId id;
    private String name;
    private String username;
    private String photo;
}
