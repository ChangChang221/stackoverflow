package com.stackoverflow.nhom24.controller;

import com.stackoverflow.nhom24.business.QuestionBusiness;
import com.stackoverflow.nhom24.model.response.QuestionResponse;
import lombok.AllArgsConstructor;
import org.hibernate.search.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private final QuestionBusiness questionBusiness;

    @GetMapping(value = "/")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public String home(final ModelMap model, Integer page) {

        if (page == null) {
            page = 1;
        }
        int total = questionBusiness.getTotal("newest");
        List<QuestionResponse> questions = questionBusiness.getAll(page, "newest");
        System.out.print("aaaaaaaaaa" + questions);
        model.addAttribute("pagination", (int) (total / 10) + 1);
        model.addAttribute("total", total);
        model.addAttribute("questions", questions);
        model.addAttribute("page", page);
        return "home";
    }
}
