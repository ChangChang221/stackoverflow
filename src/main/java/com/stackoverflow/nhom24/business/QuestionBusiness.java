package com.stackoverflow.nhom24.business;

import com.stackoverflow.nhom24.business.base.BaseBusiness;
import com.stackoverflow.nhom24.entity.Question;
import com.stackoverflow.nhom24.entity.Tag;
import com.stackoverflow.nhom24.model.response.QuestionDetailResponse;
import com.stackoverflow.nhom24.model.response.QuestionResponse;
import com.stackoverflow.nhom24.model.response.QuestionsResponse;
import com.stackoverflow.nhom24.repository.QuestionRepository;
import com.stackoverflow.nhom24.repository.TagRepository;
import com.stackoverflow.nhom24.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class QuestionBusiness extends BaseBusiness {
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;

    private final QuestionService questionService;

    public List<QuestionResponse> getAll(){
//        List<Question> questionsDto = questionRepository.findAll();
//        List<QuestionResponse> response = mapper.mapAsList(questionsDto, QuestionResponse.class);
        List<QuestionResponse> response = questionService.findAllQuestionAndItem();
        return response;
    }

    public Question postQuestion(Question question) {
        List<Tag> tagsDto = tagRepository.findAll();
        List<Tag> tagsPost = question.getTags();
        for(Tag tag : tagsDto) {
             for(Tag tagPost : tagsPost) {
              if(tag.getName().equals(tagPost)) {
                  tagPost.setId(tag.getId());
              }
            };
        };
        List<Tag> tags = tagsPost.stream().map(tag -> {
            if (tag.getId() == null) {
                tag = tagRepository.save(tag);
            }
            return tag;
        }).collect(Collectors.toList());
        question.setTags(tags);
        return questionRepository.save(question);
    }

    public QuestionDetailResponse getById(String id) {
        QuestionDetailResponse question = questionService.findQuestionAndItemById(id);
        return question;
    }
}
