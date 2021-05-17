package com.stackoverflow.nhom24.controller;

import com.stackoverflow.nhom24.business.AnswerBusiness;
import com.stackoverflow.nhom24.business.QuestionBusiness;
import com.stackoverflow.nhom24.controller.base.BaseController;
import com.stackoverflow.nhom24.entity.Answer;
import com.stackoverflow.nhom24.model.response.DataResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.util.Map;

@RestController
@AllArgsConstructor
public class AnswerRestController extends BaseController {

    private final AnswerBusiness answerBusiness;
    private final QuestionBusiness questionBusiness;

    @PostMapping("/answers/postAnswer")
    public ResponseEntity<DataResponse> postAnswer(@RequestBody Map<String, Object> data,
                                                   HttpServletRequest req,
                                                   Principal principal) {
        String body = (String) data.get("body");
        String questionId = (String) data.get("questionId");
        Answer answer = new Answer();
        answer.setBody(body);
        answer.setUserId(new String(getUserId(principal, req)));
        answer.setCreatedOn(new Date());
        answer.setScore(0);
        answer.setQuestionId(new String(questionId));
        answerBusiness.saveAnswer(answer);
        questionBusiness.updateNumberAnswer(questionId);
        DataResponse response = new DataResponse();
        response.setStatus(1);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/answers/upVote")
    public ResponseEntity<DataResponse> voteAnswer(@RequestBody Map<String, Object> data,
                                                   HttpServletRequest req,
                                                   Principal principal){
          String answerId = (String) data.get("answerId");
          String userId = getUserId(principal, req);
          Answer answer = answerBusiness.upVote(answerId, userId);
        DataResponse response = new DataResponse();
        response.setResult(answer);
        response.setStatus(1);
        return ResponseEntity.ok(response);
    }
}
