package com.stackoverflow.nhom24.controller.admin;

import com.stackoverflow.nhom24.business.QuestionBusiness;
import com.stackoverflow.nhom24.model.response.QuestionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PostAdminController {

    private final QuestionBusiness questionBusiness;

    @GetMapping("/test/adminPost")
    public String getAllPost(final ModelMap model){

     //   List<QuestionResponse> questions =questionBusiness.getAll();
     //   model.addAttribute("questions", questions);
        return "adminPosts";
    }
}

