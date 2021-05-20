package com.stackoverflow.nhom24.controller;

import com.stackoverflow.nhom24.business.AnswerBusiness;
import com.stackoverflow.nhom24.business.QuestionBusiness;
import com.stackoverflow.nhom24.business.UserBusiness;
import com.stackoverflow.nhom24.controller.base.BaseController;
import com.stackoverflow.nhom24.entity.User;
import com.stackoverflow.nhom24.model.request.LoginRequest;
import com.stackoverflow.nhom24.model.request.SignUpRequest;
import com.stackoverflow.nhom24.model.response.QuestionResponse;
import com.stackoverflow.nhom24.model.response.UserResponse;
import com.stackoverflow.nhom24.utils.EncrytedPasswordUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@AllArgsConstructor
public class UserController extends BaseController {

    private final UserBusiness userBusiness;
    private final AnswerBusiness answerBusiness;
    private final QuestionBusiness questionBusiness;

    private final String imagePath = "E:/Project handle/stackoverflow/src/main/resources/asset";

    @GetMapping( "/users/auth")
    public String auth(final ModelMap model) {
        model.addAttribute("user", new SignUpRequest());
        model.addAttribute("login", new LoginRequest());
        return "login";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("user") SignUpRequest model){
        User user = new User();
        user.setUsername(model.getEmailSignUp());
        user.setName(model.getNameSignUp());
        user.setPassword(EncrytedPasswordUtils.encrytedPassword(model.getPasswordSignUp()));
        user.setRole("ROLE_USER");
        User newUser = userBusiness.createUser(user);

        return "redirect:/users/auth";
    }

    @GetMapping("/users/{id}")
    public String getUserById(final ModelMap model, @PathVariable String id) {
        List<QuestionResponse> questions = questionBusiness.getByUserId(id);
        User user = userBusiness.getById(id);
        userBusiness.updateView(user);
        model.addAttribute("user", user);
        model.addAttribute("questions", questions);
        return "userDetail";
    }

    @GetMapping("/users")
    public String getAllUser(final ModelMap modelMap) {
        modelMap.addAttribute("users", userBusiness.getListUser());
        return "users";
    }

    @GetMapping("/users/edit/{id}")
    public String getProfile(final ModelMap model, Principal principal, HttpServletRequest request, @PathVariable String id) {
//        String userId = getUserId(principal, request);
        User users = userBusiness.getById(id);
        model.addAttribute("user", users);
        return "userEditProfile";
    }

    @PostMapping("/users/editProfile/{id}")
    public String editUser(final ModelMap model, Principal principal, HttpServletRequest request ,
                           @ModelAttribute("user") User user, @RequestParam("postImg") MultipartFile postImg, @PathVariable String id) throws IOException {
        try {
            if( postImg != null && postImg.getSize() > 0 ) {
                Date dateNow = new Date();
                Random rd = new Random();
                String name =  id + dateNow.getTime() + rd.nextInt() + postImg.getOriginalFilename().replace(' ', '1');
                postImg.transferTo(new File( imagePath + "/" + name));
                user.setPhoto(name);
            }
            userBusiness.updateUser(id, user);
            return "redirect:/users/" + id;
        } catch (Exception e){
            model.addAttribute("status", false);
            return "redirect:/users/edit/" + id;
        }

    }
}

