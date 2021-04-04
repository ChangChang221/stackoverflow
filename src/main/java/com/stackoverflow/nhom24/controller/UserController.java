package com.stackoverflow.nhom24.controller;

import com.stackoverflow.nhom24.business.UserBusiness;
import com.stackoverflow.nhom24.controller.base.BaseController;
import com.stackoverflow.nhom24.entity.User;
import com.stackoverflow.nhom24.model.request.UserRequest;
import com.stackoverflow.nhom24.model.response.UserResponse;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController extends BaseController {

    private final UserBusiness userBusiness;

    @GetMapping( "/admin/users")
    public List<UserResponse> getUser() {
        List<UserResponse> responses = userBusiness.getAllUser();
        return responses;
    }

    @GetMapping("/admin/users/{id}")
    public UserResponse getById(@PathVariable("id") Integer id){
        return userBusiness.findById(id);
    }

    @PostMapping("/admin/users")
    public UserResponse createUser(@RequestBody UserRequest model) {
        User user = mapper.map(model, User.class);
        UserResponse response = userBusiness.insertUser(user);
        return response;
    }

    @PutMapping("/admin/users/{id}")
    public UserResponse updateUser(@RequestParam Integer id,@RequestBody UserRequest model) throws NotFoundException {
        User user = mapper.map(model, User.class);
        user.setId(id);
        UserResponse response = userBusiness.updateUser(user);
        return response;
    }

    @DeleteMapping("/admin/users/{id}")
    public void deleteUser(@RequestParam Integer id){
        userBusiness.deleteById(id);
    }
}

