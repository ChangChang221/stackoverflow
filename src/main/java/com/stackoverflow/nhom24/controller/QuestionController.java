package com.stackoverflow.nhom24.controller;

import com.stackoverflow.nhom24.business.AnswerBusiness;
import com.stackoverflow.nhom24.business.QuestionBusiness;
import com.stackoverflow.nhom24.entity.Answer;
import com.stackoverflow.nhom24.entity.Question;
import com.stackoverflow.nhom24.model.response.AnswerResponse;
import com.stackoverflow.nhom24.model.response.QuestionDetailResponse;
import com.stackoverflow.nhom24.model.response.QuestionResponse;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@AllArgsConstructor
public class QuestionController {

    private final QuestionBusiness questionBusiness;
    private final AnswerBusiness answerBusiness;

    @GetMapping("/questions/askQuestion")
    public String askQuestionForm(final ModelMap model){
        model.addAttribute("question", new Question());
//        model.addAttribute("tags", new ArrayList<String>());
        return "askQuestion";
    }

    @PostMapping("/questions")
    public String postAskQuestion(@ModelAttribute("question") Question model){
        //todo redirect detail
        return "home";
    }

    @GetMapping("/questions")
    public String getAllQuestion(final ModelMap model, String page, String tab) {
        boolean statusPage = true;
        boolean statustab = true;
        if(page == null) {
            statusPage = false;
            page ="1";
        }
        if(tab == null) {
            statustab = false;
            tab = "newest";
        }
        int total = questionBusiness.getTotal(tab);
        List<QuestionResponse> questions = questionBusiness.getAll(Integer.parseInt(page), tab);
        model.addAttribute("pagination", (int) ( total/ 15) + 1);
        model.addAttribute("total", total);
        model.addAttribute("questions", questions);
        model.addAttribute("page", page);
        model.addAttribute("statusPage", statusPage);
        model.addAttribute("statustab", statustab);
        return "questions";
    }

    @GetMapping("/questions/detail/{id}")
    public String questionDetail(final ModelMap model, @PathVariable String id) {
        QuestionDetailResponse response = questionBusiness.getById(id);
        List<AnswerResponse> answers = answerBusiness.getByQuestionId(new ObjectId(id));
        System.out.println("answers: " + answers.get(1).getUser().getPhoto());
        model.addAttribute("question", response);
        model.addAttribute("answers", answers);
        return "questionDetail";
    }



}
