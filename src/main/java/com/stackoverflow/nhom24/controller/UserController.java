package com.stackoverflow.nhom24.controller;

import com.stackoverflow.nhom24.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController extends BaseController {

    @GetMapping( "/admin/signup")
    public String login() {
        return "login";
    }

}

