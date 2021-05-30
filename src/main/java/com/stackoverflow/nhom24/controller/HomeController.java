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

    public String home(final ModelMap model, Integer page, String tab, Integer startPagination) {
        if (tab == null) {
            tab = "newest";
        }

        if (page == null) {
            page = 1;
        }
        if (startPagination == null) {
            startPagination = 0;
        }
        if (page > startPagination + 10) {
            startPagination = startPagination + 10;
        }
        if (page < startPagination) {
            startPagination = startPagination - 10;
        }
        int total = questionBusiness.getTotal(tab);
        int totalPagination = (total / 15) + 1;
        if (startPagination + 10 >= totalPagination) {
            startPagination = totalPagination - 10;
        } else if (startPagination <= 1) {
            startPagination = 0;
        }
        System.out.println("startPagination: " + startPagination);
        System.out.println("page: " + page);
        System.out.println("total: " + total);
        List<QuestionResponse> questions = questionBusiness.getAll(page, tab);
        model.addAttribute("pagination", totalPagination);
        model.addAttribute("total", questions.size());
        model.addAttribute("questions", questions);
        model.addAttribute("page", page);
        model.addAttribute("startPagination", startPagination);
        model.addAttribute("endPagination", startPagination + 10);
        model.addAttribute("sidebar", 1);
        return "home";
    }
}
