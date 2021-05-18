package com.stackoverflow.nhom24.controller;

import com.stackoverflow.nhom24.business.QuestionBusiness;
import com.stackoverflow.nhom24.model.response.QuestionResponse;
import com.stackoverflow.nhom24.utils.EncrytedPasswordUtils;
import lombok.AllArgsConstructor;
import org.hibernate.search.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private final QuestionBusiness questionBusiness;

    @GetMapping(value = "/")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public String home(final ModelMap model, Integer page) throws ParseException {

        if (page == null) {
            page = 1;
        }
//        int total = questionBusiness.getTotal("newest");
        int total = 10;
        List<QuestionResponse> questions = questionBusiness.getAll(page, "newest");
        questionBusiness.createCommentAndAnswerId();
//        questionBusiness.createData();
        System.out.println(EncrytedPasswordUtils.encrytedPassword("1"));

        model.addAttribute("pagination", (int) (total / 10) + 1);
        model.addAttribute("total", total);
        model.addAttribute("questions", questions);
        model.addAttribute("page", page);
        return "home";
    }
}
