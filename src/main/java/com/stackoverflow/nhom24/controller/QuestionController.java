package com.stackoverflow.nhom24.controller;

import com.stackoverflow.nhom24.entity.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionController {

    @GetMapping("/questions/askQuestion")
    public String askQuestionForm(final ModelMap model){
        model.addAttribute("question", new Question());
        return "askQuestion";
    }

    @PostMapping("/questions")
    public String postAskQuestion(@ModelAttribute("question") Question model){
        //todo redirect detail
        return "home";
    }
}
