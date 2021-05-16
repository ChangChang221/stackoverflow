package com.stackoverflow.nhom24.business;

import com.stackoverflow.nhom24.business.base.BaseBusiness;
import com.stackoverflow.nhom24.entity.Question;
import com.stackoverflow.nhom24.entity.Tag;
import com.stackoverflow.nhom24.model.response.QuestionDetailResponse;
import com.stackoverflow.nhom24.model.response.QuestionResponse;
import com.stackoverflow.nhom24.model.response.QuestionsResponse;
import com.stackoverflow.nhom24.model.response.TagResponse;
import com.stackoverflow.nhom24.repository.QuestionRepository;
import com.stackoverflow.nhom24.repository.TagRepository;
import com.stackoverflow.nhom24.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class QuestionBusiness extends BaseBusiness {
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;
    private final TagBusiness tagBusiness;

    private final QuestionService questionService;

    public List<QuestionResponse> getAll(){
//        List<Question> questionsDto = questionRepository.findAll();
//        List<QuestionResponse> response = mapper.mapAsList(questionsDto, QuestionResponse.class);
        List<QuestionResponse> response = questionService.findAllQuestionAndItem();
        return response;
    }

    public List<TagResponse> countQuestionTag(List<Tag> tags) {

        List<TagResponse> tagsResponse = mapper.mapAsList(tags, TagResponse.class);
        for (TagResponse tag : tagsResponse){
            int numberQuestion = 1;
            tag.setNumberQuestion(numberQuestion);
        }

//        List<QuestionResponse> response = getAll();
//        int sizeResponse = response.size();
//
//        List<TagResponse> tagResponseList;
//        List<String> nameTag = tagBusiness.getNameTag();
//        int sizeNameTag = nameTag.size();
//
//        List<Integer> integerList = new ArrayList<>();
//        for (int i = 0; i < sizeNameTag; i++) {
//            integerList.add(0);
//        }
//        for (int i = 0; i < sizeResponse; i++) {
//
//            List<TagResponse> tagList = response.get(i).getTags();
//            int sizeTagList = tagList.size();
//
//            for (int j = 0; j < sizeNameTag; j++) {
//                for (int k = 0; k < sizeTagList; k++) {
//                    if (tagList.get(k).getName() == nameTag.get(j)) {
//                        integerList.set(j, integerList.get(j) + 1);
//                    }
//                }
//            }
//        }

//        return integerList;
        return tagsResponse;
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
