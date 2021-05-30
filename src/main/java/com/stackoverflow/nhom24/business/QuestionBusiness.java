package com.stackoverflow.nhom24.business;

import com.stackoverflow.nhom24.business.base.BaseBusiness;
import com.stackoverflow.nhom24.entity.Question;
import com.stackoverflow.nhom24.entity.Tag;
import com.stackoverflow.nhom24.entity.User;
import com.stackoverflow.nhom24.model.response.*;
import com.stackoverflow.nhom24.repository.QuestionRepository;
import com.stackoverflow.nhom24.repository.TagRepository;
import com.stackoverflow.nhom24.repository.UserRepository;
import com.stackoverflow.nhom24.service.AnswerService;
import com.stackoverflow.nhom24.service.QuestionService;
import com.stackoverflow.nhom24.utils.EncrytedPasswordUtils;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class QuestionBusiness extends BaseBusiness {
    
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;
    private final UserRepository userRepository;

    private final QuestionService questionService;
    private final TagBusiness tagBusiness;
    private final AnswerService answerService;

    public List<Question> getAll(){
        List<Question> response= questionRepository.findAll();
        return response;
    }

    public List<QuestionResponse> getAll(Integer page, String tab) {
        List<QuestionResponse> response = questionService.findAllQuestionAndItem(page, tab);
        return response;
    }

    public List<QuestionResponse> getALlByCondition(Integer page, String query, String tag){
        return questionService.findAllByCondition(page, query, tag, false);
    }

    public int getCountByCondition(Integer page, String query, String tag){
        return questionService.findAllByCondition(page, query, tag, true).size();
    }

    public List<LiveSearchQuestionResponse> getQuestions(String query) {
        List<LiveSearchQuestionResponse> response = questionService.getQuestions(query);
        return response;
    }

    public List<QuestionResponse> getByUserId(String userId) {
        return questionService.getByUserId(new ObjectId(userId));
    }

    public List<QuestionResponse> getQuestionOfAnswerByUserId(String userId) {
        return questionService.getQuestionOfAnswerByUserId(new ObjectId(userId));
    }

    public void setRole() {
        List<User> users = userRepository.findAll();
        for (User el : users) {
            userRepository.save(el);
        }

    }

    public void updatePhoto() {
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

    public DataResponse postQuestion(Question question) {
        try {
//            List<Tag> tagsDto = tagRepository.findAll();
//            for (Tag tag : tagsDto) {
//                for (Tag tagPost : tagsPost) {
//                    if (tag.getName().equals(tagPost.getName())) {
//                        tagPost.setId(tag.getId());
//                    }
//                }
//                ;
//            }
//            ;
//            List<Tag> tags = tagsPost.stream().map(tag -> {
//                if (tag.getId() == null) {
//                    tag = tagRepository.save(tag);
//                }
//                return tag;
//            }).collect(Collectors.toList());
//            question.setTags(tags.stream().map(el -> el.getName()).collect(Collectors.toList()));
            question.setId(new ObjectId());
            questionRepository.save(question);
            DataResponse data = new DataResponse();
            Object result = question.getId().toString();
            data.setStatus(1);
            data.setResult(result);
            return data;
        } catch (Exception e) {
            //System.out.println("QuestionBusiness postQuestion error: "+ e.getMessage());
            DataResponse data = new DataResponse();
            data.setStatus(0);
            return data;
        }

    }

    public QuestionDetailResponse getById(String id) {
        try {
            QuestionDetailResponse question = questionService.findQuestionAndItemById(id);
            Question updateQuestion = questionRepository.findById(new ObjectId(id)).get();
            updateQuestion.setViews(updateQuestion.getViews() + 1);
            questionRepository.save(updateQuestion);
            return question;
        } catch (Exception e) {
            //System.out.println("QuestionDetailResponse: " + e.getMessage());
            return new QuestionDetailResponse();
        }

    }

    public void updateNumberAnswer(ObjectId questionId) {
        Question question = questionRepository.findById(questionId).get();
        question.setAnswers(question.getAnswers() + 1);
        questionRepository.save(question);
    }


    public List<QuestionResponse> getQuestionByTag(String tag, long page){
        return questionService.getByTag(tag, page);
    }

    public List<TagResponse> countQuestionTag(List<Tag> tags, int page, String tab) {

        List<TagResponse> tagsResponse = mapper.mapAsList(tags, TagResponse.class);

        //get name tag
        List<String> nameTag = tagBusiness.getNameTag(page);
        int sizeNameTag = nameTag.size();
//        //System.out.println("sizenametag = " + sizeNameTag);

//        System.out.print("nameTag = " );
        for(int j = 0; j < sizeNameTag; j++) {
//            System.out.print(nameTag.get(j) + ", ");
        }
//        //System.out.println();

//        //System.out.println("gettotal = " + tagBusiness.getTotal()/10 + 1);
        for (int i = 0; i < 15; i++) {
            tagsResponse.get(i).setNumberQuestion(0);
            /*TagResponse tagResponse = new TagResponse();
            tagResponse.setNumberQuestion(0);
            tagsResponse.add(tagResponse);*/
        }

        //get questions response

        List<Question> response = questionRepository.findAll();
        int sizeResponse = response.size();
//        //System.out.println("sizeResponse = " + sizeResponse);

//        //System.out.println();
        for (int i = 0; i < sizeResponse; i++) {

            //get tag of a question
            List<String> tagList = response.get(i).getTags();
            int sizeTagList = tagList.size();

//            System.out.print("tagList = ");
            for (int k = 0; k < sizeTagList; k++) {
                System.out.print(tagList.get(k) + ", ");
            }
//            //System.out.println();
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
