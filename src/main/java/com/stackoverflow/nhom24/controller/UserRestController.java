package com.stackoverflow.nhom24.controller;

import com.stackoverflow.nhom24.business.TagBusiness;
import com.stackoverflow.nhom24.business.UserBusiness;
import com.stackoverflow.nhom24.model.response.DataResponse;
import com.stackoverflow.nhom24.model.response.TagResponse;
import com.stackoverflow.nhom24.model.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class UserRestController {
    private final UserBusiness userBusiness;

    @GetMapping("/users/search")
    @CrossOrigin(origins = "*")
    public ResponseEntity<DataResponse> filterTag(String query){
        List<UserResponse> users = userBusiness.filterUser(query);
        List<UserResponse> userResponse = userBusiness.getTagOfUser(users);
        DataResponse response = new DataResponse();
        response.setResult(userResponse);
        response.setStatus(1);
        return ResponseEntity.ok(response);
    }
}
