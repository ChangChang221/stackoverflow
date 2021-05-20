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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class QuestionBusiness extends BaseBusiness {
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;
    private final TagBusiness tagBusiness;

    private final QuestionService questionService;

    public List<QuestionResponse> getAll(Integer page, String tab){
        List<QuestionResponse> response = questionService.findAllQuestionAndItem(page, tab);
        return response;
    }


    public int getTotal(String tab) {
        return questionService.findCountOfQuestionAndItem(tab);
    }

    public Question postQuestion(Question question, List<Tag> tagsPost) {
        List<Tag> tagsDto = tagRepository.findAll();
        for(Tag tag : tagsDto) {
             for(Tag tagPost : tagsPost) {
              if(tag.getName().equals(tagPost.getName())) {
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
        question.setTags(tags.stream().map(el -> el.getName()).collect(Collectors.toList()));
        return questionRepository.save(question);
    }

    public QuestionDetailResponse getById(String id) {
        QuestionDetailResponse question = questionService.findQuestionAndItemById(id);
        Question updateQuestion = questionRepository.findById(id).get();
        updateQuestion.setViews(updateQuestion.getViews() + 1);
        questionRepository.save(updateQuestion);
        return question;
    }

    public void updateNumberAnswer(String questionId){
        Question question = questionRepository.findById(questionId).get();
        question.setAnswers(question.getAnswers() + 1);
        questionRepository.save(question);
    }

    public List<TagResponse> countQuestionTag(List<Tag> tags, int page, String tab) {

        List<TagResponse> tagsResponse = mapper.mapAsList(tags, TagResponse.class);

        //get name tag
        List<String> nameTag = tagBusiness.getNameTag(page);
        int sizeNameTag = nameTag.size();
        System.out.println("sizenametag = " + sizeNameTag);

        System.out.print("nameTag = " );
        for(int j = 0; j < sizeNameTag; j++) {
            System.out.print(nameTag.get(j) + ", ");
        }
        System.out.println();

        System.out.println("gettotal = " + tagBusiness.getTotal()/10 + 1);
        for (int i = 0; i < 15; i++) {
            tagsResponse.get(i).setNumberQuestion(0);
            /*TagResponse tagResponse = new TagResponse();
            tagResponse.setNumberQuestion(0);
            tagsResponse.add(tagResponse);*/
        }

        //get questions response

        List<Question> response = questionRepository.findAll();
        int sizeResponse = response.size();
        System.out.println("sizeResponse = " + sizeResponse);

        System.out.println();
        for (int i = 0; i < sizeResponse; i++) {

            //get tag of a question
            List<String> tagList = response.get(i).getTags();
            int sizeTagList = tagList.size();

            System.out.print("tagList = ");
            for (int k = 0; k < sizeTagList; k++) {
                System.out.print(tagList.get(k) + ", ");
            }
            System.out.println();
            for (int j = 0; j < sizeNameTag; j++) {
                for (int k = 0; k < sizeTagList; k++) {
                    if (tagList.get(k).equals(nameTag.get(j))) {
                        tagsResponse.get(j).setNumberQuestion(tagsResponse.get(j).getNumberQuestion() + 1);
                    }
                }
            }
        }


        return tagsResponse;
    }

}
