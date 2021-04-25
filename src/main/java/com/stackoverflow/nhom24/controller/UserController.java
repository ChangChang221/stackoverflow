package com.stackoverflow.nhom24.controller;

import com.stackoverflow.nhom24.business.UserBusiness;
import com.stackoverflow.nhom24.controller.base.BaseController;
import com.stackoverflow.nhom24.entity.User;
import com.stackoverflow.nhom24.model.request.LoginRequest;
import com.stackoverflow.nhom24.model.request.SignUpRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@Controller
@AllArgsConstructor
public class UserController extends BaseController {

    private final UserBusiness userBusiness;

    @GetMapping( "/users")
    public String auth(final ModelMap model) {
        model.addAttribute("user", new SignUpRequest());
        model.addAttribute("login", new LoginRequest());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("login") LoginRequest model){
        System.out.println(model.getEmail()+ model.getPassword());
        return "home";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("user") SignUpRequest model){
        User user = new User();
        user.setUsername(model.getEmailSignUp());
        user.setName(model.getNameSignUp());
        user.setPassword(model.getPasswordSignUp());
        user.setRole("USER");
        User newUser = userBusiness.createUser(user);
        System.out.println(newUser);
        return "home";
    }
}

