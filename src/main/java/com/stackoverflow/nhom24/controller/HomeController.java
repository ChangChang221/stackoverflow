package com.stackoverflow.nhom24.controller;

import com.stackoverflow.nhom24.business.QuestionBusiness;
import com.stackoverflow.nhom24.model.response.QuestionResponse;
import com.stackoverflow.nhom24.model.response.QuestionsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {
    private final QuestionBusiness questionBusiness;

    @GetMapping(value = "/")
    public String home(final ModelMap model){

        List<QuestionResponse> questions = questionBusiness.getAll();
        model.addAttribute("questions", questions);
        return "home";
    }
}
