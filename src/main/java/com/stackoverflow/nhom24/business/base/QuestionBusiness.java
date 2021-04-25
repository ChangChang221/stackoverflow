package com.stackoverflow.nhom24.business.base;

import com.stackoverflow.nhom24.entity.Question;
import com.stackoverflow.nhom24.model.response.QuestionResponse;
import com.stackoverflow.nhom24.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class QuestionBusiness {
    private final QuestionRepository questionRepository;

    public Question postQuestion(Question question) {
        return questionRepository.save(question);
    }

    public QuestionResponse getById(String id){
        Question question = questionRepository.findById(id).get();
        return new QuestionResponse();
    }
}
