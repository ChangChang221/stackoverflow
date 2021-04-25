package com.stackoverflow.nhom24.controller;

import com.stackoverflow.nhom24.business.base.QuestionBusiness;
import com.stackoverflow.nhom24.entity.Question;
import com.stackoverflow.nhom24.model.response.DataResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class QuestionRestController {

    private final QuestionBusiness questionBusiness;

    @PostMapping("/question/postAskQuestion")
    @CrossOrigin(origins = "*")
    public ResponseEntity<DataResponse> postAskQuestion(@RequestBody Map<String, Object> data, HttpServletRequest req, HttpServletResponse res){
        String title = (String) data.get("title");
        String body = (String) data.get("body");
        Question question = new Question();
        question.setBody(body);
        question.setTitle(title);
        question.setNumberOfVote(0);
        question.setCreatedOn(new Date());
        question.setViews(0);
        Question newQuestion = questionBusiness.postQuestion(question);
        DataResponse response = new DataResponse();
        response.setResult(newQuestion);
        response.setStatus(1);
        return ResponseEntity.ok(response);
    }
}
