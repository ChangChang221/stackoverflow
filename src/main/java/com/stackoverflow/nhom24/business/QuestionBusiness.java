package com.stackoverflow.nhom24.business;

import com.stackoverflow.nhom24.business.base.BaseBusiness;
import com.stackoverflow.nhom24.entity.Question;
import com.stackoverflow.nhom24.entity.Tag;
import com.stackoverflow.nhom24.entity.User;
import com.stackoverflow.nhom24.model.response.LiveSearchQuestionResponse;
import com.stackoverflow.nhom24.model.response.QuestionDetailResponse;
import com.stackoverflow.nhom24.model.response.QuestionResponse;
import com.stackoverflow.nhom24.model.response.QuestionsResponse;
import com.stackoverflow.nhom24.repository.QuestionRepository;
import com.stackoverflow.nhom24.repository.TagRepository;
import com.stackoverflow.nhom24.repository.UserRepository;
import com.stackoverflow.nhom24.service.QuestionService;
import com.stackoverflow.nhom24.utils.EncrytedPasswordUtils;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class QuestionBusiness extends BaseBusiness {
    
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;
    private final UserRepository userRepository;

    private final QuestionService questionService;

    public List<QuestionResponse> getAll(Integer page, String tab) {
        List<QuestionResponse> response = questionService.findAllQuestionAndItem(page, tab);
        return response;
    }

    public List<LiveSearchQuestionResponse> getQuestions(String query){
        List<LiveSearchQuestionResponse> response = questionService.getQuestions(query);
        return response;
    }

    public List<QuestionResponse> getByUserId(String userId){
        return questionService.getByUserId(new ObjectId(userId));
    }

    public void setRole(){
        List<User> users = userRepository.findAll();
        for (User el : users){
            userRepository.save(el);
        }

    }

    public void updatePhoto(){
        List<String> photo = new ArrayList<>();
        photo.add("avatarBase.png");
        photo.add("avatar4.jpg");
        photo.add("avatar3.jpeg");
        photo.add("avatarBase.png");
        photo.add("avatar2.jpg");
        photo.add("avatar1.png");
        photo.add("60a489a4a67d0d48bf2f2e001621440330174-1290789959-1998056832876314185img.jpeg");
        List<User> users = userRepository.findAll();
        for (User el : users){
            Random rand = new Random();
            int ranNum = rand.nextInt(6);
            el.setPhoto(photo.get(ranNum));
            userRepository.save(el);
        }
    }

    public int getTotal(String tab) {
        return questionService.findCountOfQuestionAndItem(tab);
    }

    public Question postQuestion(Question question, List<Tag> tagsPost) {
        List<Tag> tagsDto = tagRepository.findAll();
        for (Tag tag : tagsDto) {
            for (Tag tagPost : tagsPost) {
                if (tag.getName().equals(tagPost.getName())) {
                    tagPost.setId(tag.getId());
                }
            }
            ;
        }
        ;
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
        try{
            QuestionDetailResponse question = questionService.findQuestionAndItemById(id);
//            Question updateQuestion = questionRepository.findById(new  ObjectId(id)).get();
//            updateQuestion.setViews(updateQuestion.getViews() + 1);
//            questionRepository.save(updateQuestion);
            return question;
        }catch (Exception e){
            System.out.println("QuestionDetailResponse: "+ e.getMessage());
            return new QuestionDetailResponse();
        }

    }

    public void updateNumberAnswer(ObjectId questionId) {
        Question question = questionRepository.findById(questionId).get();
        question.setAnswers(question.getAnswers() + 1);
        questionRepository.save(question);
    }

}
