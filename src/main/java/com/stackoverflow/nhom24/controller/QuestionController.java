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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


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
    public String getAllQuestion(final ModelMap model, Integer page, String tab, Integer startPagination) {
        boolean statusPage = true;
        boolean statustab = true;
        if(page == null) {
            statusPage = false;
            page = 1;
        }
        if(tab == null) {
            statustab = false;
            tab = "newest";
        }
        if(startPagination == null){
            startPagination = 0;
        }
        if(page > startPagination + 10){
            startPagination = startPagination + 10;
        } if(page < startPagination){
            startPagination = startPagination - 10;
        }
//        if(search == null && tag == null){
//            search = "";
//        }
//        List<QuestionResponse> questions = questionBusiness.getALlByCondition(page, search, tag);
//        int total = questionBusiness.getCountByCondition(page, search, tag);

        int total = questionBusiness.getTotal(tab);
        //System.out.println("totalPagination: " + total);
        int totalPagination = (total / 15) + 1;
        if(startPagination + 10 >= totalPagination){
            startPagination = totalPagination - 10;
        } if(startPagination <= 1){
            startPagination = 0;
        }
        int endPagination = 10;
        if(totalPagination < 10){
            endPagination = totalPagination;
        }
        List<QuestionResponse> questions = questionBusiness.getAll(page, tab);
//        model.addAttribute("tag", tag);
        model.addAttribute("pagination", totalPagination);
        model.addAttribute("total", total);
        model.addAttribute("questions", questions);
        model.addAttribute("page", page);
        model.addAttribute("statusPage", statusPage);
        model.addAttribute("statustab", statustab);
        model.addAttribute("startPagination", startPagination);
        model.addAttribute("endPagination", endPagination);
        model.addAttribute("sidebar", 1);
        return "questions";
    }

    @GetMapping("/questions/detail/{id}")
    public String questionDetail(final ModelMap model, @PathVariable String id) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<List<AnswerResponse>> answersAsync = CompletableFuture.supplyAsync(() -> answerBusiness.getByQuestionId(new ObjectId(id)));
//        List<AnswerResponse> answers = answerBusiness.getByQuestionId(new ObjectId(id));
//        QuestionDetailResponse response = questionBusiness.getById(id);
        CompletableFuture<QuestionDetailResponse> responseAsync = CompletableFuture.supplyAsync(() -> questionBusiness.getById(id));
        model.addAttribute("question", responseAsync.get());
        model.addAttribute("answers", answersAsync.get());
        long end = System.currentTimeMillis();
        System.out.println(end - start + "    time");
        model.addAttribute("sidebar", 1);
        return "questionDetail";
    }

    @GetMapping("/questions/search")
    public String searchQuestion(final ModelMap model, String search, String tag, String tab, Integer page, Integer startPagination){
        boolean statusPage = true;
        boolean statustab = true;
        if(page == null) {
            statusPage = false;
            page = 1;
        }
        if(tab == null) {
            statustab = false;
            tab = "relevance";
        }
        if(startPagination == null){
            startPagination = 0;
        }
        if(page > startPagination + 10){
            startPagination = startPagination + 10;
        } if(page < startPagination){
            startPagination = startPagination - 10;
        }
        if(search == null && tag == null){
            search = "";
        }
        List<QuestionResponse> questions = questionBusiness.getALlByCondition(page, search, tag);
        int total = questionBusiness.getCountByCondition(page, search, tag);

        int totalPagination = (total / 15) + 1;
        if(startPagination + 10 >= totalPagination){
            startPagination = totalPagination - 10;
        } if(startPagination <= 1){
            startPagination = 0;
        }
        int endPagination = 10;
        if(totalPagination < 10){
            endPagination = totalPagination;
        }
        model.addAttribute("query", search);
        model.addAttribute("tag", tag);
        model.addAttribute("pagination", totalPagination);
        model.addAttribute("total", total);
        model.addAttribute("questions", questions);
        model.addAttribute("page", page);
        model.addAttribute("statusPage", statusPage);
        model.addAttribute("statustab", statustab);
        model.addAttribute("startPagination", startPagination);
        model.addAttribute("endPagination", endPagination);
        model.addAttribute("sidebar", 1);
        return "searchQuestion";
    }



}
