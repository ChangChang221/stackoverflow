package com.stackoverflow.nhom24.business;

import com.stackoverflow.nhom24.business.base.BaseBusiness;
import com.stackoverflow.nhom24.entity.*;
import com.stackoverflow.nhom24.model.response.*;
import com.stackoverflow.nhom24.repository.*;
import com.stackoverflow.nhom24.service.*;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class QuestionBusiness extends BaseBusiness {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;
    private final UserRepository userRepository;
    private final AnswerRepository answerRepository;
    private final CommentRepository commentRepository;

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserService userService;
    private final CommentService commentService;
    private final VoteService voteService;

    public List<QuestionResponse> getAll(Integer page, String tab) {
        List<QuestionResponse> response = questionService.findAllQuestionAndItem(page, tab);
        return response;
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
        QuestionDetailResponse question = questionService.findQuestionAndItemById(id);
        Question updateQuestion = questionRepository.findById(id).get();
        System.out.print("aaaaaaa" + question.getBody());
        updateQuestion.setViews(updateQuestion.getViews() + 1);
        questionRepository.save(updateQuestion);
        return question;
    }

    public void updateNumberAnswer(String questionId) {
        Question question = questionRepository.findById(questionId).get();
        question.setAnswers(question.getAnswers() + 1);
        questionRepository.save(question);
    }

    public void createCommentAndAnswerId() throws ParseException {
//        List<UserResponse> users = userService.getAll();
//        for (UserResponse el : users){
//            User user = initUser(el);
//            userRepository.save(user);
//        }
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
//        List<AnswerResponse> answers = answerService.getALl();
//        List<CommentResponse> comments = commentService.getAll();
//                for (AnswerResponse elAnswers: answers){
//                    String newAnswerId = new ObjectId().toString();
//                    for (CommentResponse elComment: comments){
//                        String newCommentId = new ObjectId().toString();
//                        elComment.setId(newCommentId);
//                        if(elComment.getAnswerId().equals(elAnswers.getId())){
//                            elComment.setAnswerId(newAnswerId);
//                        };
//                    }
//                    elAnswers.setId(newAnswerId);
//                }
//        for(AnswerResponse elAnswer : answers){
//            Answer answer = initAnswer(elAnswer);
//            answerRepository.save(answer);
//        }
//        for (CommentResponse el: comments){
//            Comment comment = initComment(el);
//            commentRepository.save(comment);
//        }
    }

    public void createData() throws ParseException {
        List<QuestionResponse> questions = questionService.findAllQuestionAndItem(1, "newest");
        List<AnswerResponse> answers = answerService.getALl();
        List<UserResponse> users = userService.getAll();
        List<CommentResponse> comments = commentService.getAll();
        List<VoteResponse> votes = voteService.getAll();

        List<User> newUsers = new ArrayList<>();
        List<Question> newQuestions = new ArrayList<>();
        List<Answer> newAnswers = new ArrayList<>();
        List<Comment> newComments = new ArrayList<>();
        for (UserResponse elUser : users) {
            String newUserId = new ObjectId().toString();
            for(QuestionResponse elQuestion : questions) {
                String newQuestionId = new ObjectId().toString();
                for (AnswerResponse elAnswers: answers){
                    String newAnswerId = new ObjectId().toString();
                    for (CommentResponse elComment: comments){
                        String newCommentId = new ObjectId().toString();
                        elComment.setId(newCommentId);
                         if(elComment.getAnswerId().equals(elAnswers.getId()) && elComment.getUserId().equals(elUser.getId())){
                            elComment.setAnswerId(newAnswerId);
                            elComment.setUserId(newUserId);
                        }
                    }
                    elAnswers.setId(newAnswerId);
                    if(elAnswers.getQuestionId().equals(elQuestion.getId()) && elAnswers.getUserId().equals(elUser.getId())) {
                        elAnswers.setQuestionId(newQuestionId);
                        elAnswers.setUserId(newUserId);
                    }
//                    Answer answer = initAnswer(elAnswers, newAnswerId);
//                    newAnswers.add(answer);
                }
                elQuestion.setId(newQuestionId);
                if(elQuestion.getUserId().equals(elUser.getId())){
                    elQuestion.setUserId(newUserId);
                }
//                Question question = initQuestion(elQuestion, newQuestionId);
//                newQuestions.add(question);
            }
            elUser.setId(newUserId);
//            User newUser = initUser(elUser, newUserId);
//            newUsers.add(newUser);
        }
        for(UserResponse elUser : users){
            User user = initUser(elUser);
            userRepository.save(user);
        }
        for (QuestionResponse elQuestion: questions){
            Question question = initQuestion(elQuestion);
            questionRepository.save(question);
        }
        for(AnswerResponse elAnswer : answers){
            Answer answer = initAnswer(elAnswer);
            answerRepository.save(answer);
        }
        for (CommentResponse el: comments){
            Comment comment = initComment(el);
            commentRepository.save(comment);
        }
        System.out.println("Success");
    }

    public Comment initComment(CommentResponse el)throws ParseException{
        Comment comment = new Comment();
        comment.setId(el.getId());
        comment.setAnswerId(el.getAnswerId());
        comment.setBody(el.getBody());
        comment.setName(el.getName());
        comment.setUserId(el.getUserId());
        comment.setAnswerId(el.getAnswerId());
        Date createdOn;
        try {
            createdOn = convertStringToDate(el.getCreatedOn());
        } catch (Exception e){
            createdOn = new Date();
        }
        comment.setCreatedOn(createdOn);
        return comment;
    }

    public Answer initAnswer(AnswerResponse el)throws ParseException{
        Answer answer = new Answer();
        answer.setId(el.getId());
        answer.setBody(el.getBody());
        answer.setScore(el.getScore());
        answer.setVotes(el.getVotes());
        answer.setQuestionId(el.getQuestionId());
        answer.setUserId(el.getUserId());
        Date createdOn;
        try {
            createdOn = convertStringToDate(el.getCreatedOn());
        } catch (Exception e){
            createdOn = new Date();
        }

        answer.setCreatedOn(createdOn);
        return answer;
    }

    public Question initQuestion(QuestionResponse el)throws ParseException{
        Question question = new Question();
        question.setTitle(el.getTitle());
        question.setViews(el.getViews());
        question.setUserId(el.getUserId());
        question.setBody(el.getBody());
        question.setAnswers(el.getAnswers());
        question.setTags(el.getTags());
        Date createdOn;
        try {
            createdOn = convertStringToDate(el.getCreatedOn());
        } catch (Exception e){
            createdOn = new Date();
        }
        question.setCreatedOn(createdOn);
        question.setId(el.getId());
        return question;
    }

    public User initUser(UserResponse el) throws ParseException {
        User user = new User();
        user.setUsername(user.getUsername());
        user.setAnswers(el.getAnswers());
        user.setName(el.getName());
        user.setBadges(el.getBadges());
        user.setLink(el.getLink());
        user.setLocation(el.getLocation());
        user.setPhoto(el.getPhoto());
        user.setReputationScore(el.getReputationScore());
        user.setRole(el.getRole());
        user.setSocial(el.getSocial());
        user.setTags(el.getTags());
        user.setQuestions(el.getQuestions());
        user.setAnswers(el.getAnswers());
        Date createdOn;
        try {
            createdOn = convertStringToDate(el.getCreatedOn());
        } catch (Exception e){
            createdOn = new Date();
        }
        user.setCreatedOn(createdOn);
        user.setId(el.getId());
        user.setPassword("$2a$10$4Ou2eFvyHQ6AjnCNvHEfhOT/Dh3b/yNNRccUs.1FoR4mdla/b0WMW");
        return user;
    }

    public List<AnswerResponse> findAnswerByQuestionIdAndUserId(String questionId,
                                                          String userId,
                                                          List<AnswerResponse> answers,
                                                          String newQuestionsId,
                                                          String newUserId){
        return answers.stream().map(el -> {
            if(el.getQuestionId().equals(questionId) && el.getUserId().equals(userId)) {
                el.setQuestionId(newQuestionsId);
                el.setUserId(newUserId);
            }
            return el;
        }).collect(Collectors.toList());
    }

    public List<QuestionResponse> findQuestionByUserId(String userId, List<QuestionResponse> questions, String newUserId) throws ParseException {
        return questions.stream().map(el -> {
            if(el.getUserId().equals(userId)){
                el.setUserId(newUserId);
            }
            return el;
        }).collect(Collectors.toList());
    }

    public List<CommentResponse> findCommentByAnswerIdAndUserId(String answerId,
                                                                String userId,
                                                                List<CommentResponse> comments,
                                                                String newAnswerId,
                                                                String newUserId){
        return comments.stream().map(el -> {
            if(el.getAnswerId().equals(answerId) && el.getUserId().equals(userId)){
                el.setAnswerId(newAnswerId);
                el.setUserId(newUserId);
            }
            return el;
        }).collect(Collectors.toList());
    }

    public VoteResponse findVoteById(String voteId, List<VoteResponse> votes){
        for (VoteResponse el: votes){
            if(el.getId().equals(voteId)){
                return el;
            }
        }
        return null;
    }

    public Date convertStringToDate(String createdOn) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(createdOn);
    }
}
