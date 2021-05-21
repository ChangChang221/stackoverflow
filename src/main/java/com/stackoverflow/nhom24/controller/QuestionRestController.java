package com.stackoverflow.nhom24.controller;

import com.stackoverflow.nhom24.business.QuestionBusiness;
import com.stackoverflow.nhom24.controller.base.BaseController;
import com.stackoverflow.nhom24.entity.Question;
import com.stackoverflow.nhom24.entity.Tag;
import com.stackoverflow.nhom24.model.response.DataResponse;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class QuestionRestController extends BaseController {

    private final QuestionBusiness questionBusiness;

    @PostMapping("/question/postAskQuestion")
    @CrossOrigin(origins = "*")
    public ResponseEntity<DataResponse> postAskQuestion(@RequestBody Map<String, Object> data, HttpServletRequest req, HttpServletResponse res, Principal principal){
        String title = (String) data.get("title");
        String body = (String) data.get("body");
        List<String> tags = (List<String>) data.get("tags");
        Question question = new Question();
        question.setBody(body);
        question.setTitle(title);
        question.setCreatedOn(new Date());
        question.setViews(0);
//        question.setUserId(new String(getUserId(principal, req)));
        question.setUserId(new ObjectId());
        question.setAnswers(0);
        Question newQuestion = questionBusiness.postQuestion(question, tags.stream().map(post -> {
            Tag tag = new Tag();
            tag.setName(post);
            return tag;
        }).collect(Collectors.toList()));
        DataResponse response = new DataResponse();
        response.setResult(newQuestion);
        response.setStatus(1);
        return ResponseEntity.ok(response);
    }

}
