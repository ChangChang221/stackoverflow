package com.stackoverflow.nhom24.business;

import com.stackoverflow.nhom24.business.base.BaseBusiness;
import com.stackoverflow.nhom24.entity.Answer;
import com.stackoverflow.nhom24.entity.Comment;
import com.stackoverflow.nhom24.entity.Vote;
import com.stackoverflow.nhom24.model.response.AnswerResponse;
import com.stackoverflow.nhom24.model.response.DataResponse;
import com.stackoverflow.nhom24.model.response.VoteResponse;
import com.stackoverflow.nhom24.repository.AnswerRepository;
import com.stackoverflow.nhom24.repository.CommentRepository;
import com.stackoverflow.nhom24.repository.UserRepository;
import com.stackoverflow.nhom24.repository.VoteRepository;
import com.stackoverflow.nhom24.service.AnswerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class AnswerBusiness extends BaseBusiness {
    private final AnswerRepository answerRepository;

    private final CommentRepository commentRepository;

    private final UserRepository userRepository;

    private final VoteRepository voteRepository;

    private final AnswerService answerService;

    public void saveAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public List<AnswerResponse> getByQuestionId(ObjectId questionId){
        List<AnswerResponse> responses = answerService.getAnswerResponsesByQuestionId(questionId);
//        for (Answer el: answers){
//            AnswerResponse answer = mapper.map(el, AnswerResponse.class);
//            User user = userRepository.findById(el.getUserId().toString()).get();
//            answer.setUser(mapper.map(user, UserResponse.class));
//        }
        System.out.println(responses);
        return responses;
    }

    public Answer upVote(ObjectId answerId, ObjectId userId, Boolean status) {
        Answer answer = answerRepository.findById(answerId).get();
        List<VoteResponse> voteResponses = answerService.getVotesByAnswerId(answerId);
        VoteResponse vote_find = voteResponses.stream().filter(voteResponse -> voteResponse.getUserId().equals(userId)).findAny().orElse(null);
        if (vote_find != null) {
            if(vote_find.getStatus() == status){
                voteRepository.deleteById(vote_find.getId());
            } else {
                Vote vote = new Vote();
                vote.setStatus(status);
                vote.setAnswerId(answerId);
                vote.setUserId(userId);
                vote.setId(vote_find.getId());
                voteRepository.save(vote);
            }
        } else {
            if (status) {
                answer.setScore(answer.getScore() + 2);
                answer = answerRepository.save(answer);
            } else {
                if (answer.getScore() <= 1) {
                    answer.setScore(0);
                } else {
                    answer.setScore(answer.getScore() - 1);
                }
            }
            Vote vote = new Vote();
            vote.setStatus(status);
            vote.setUserId(userId);
            vote.setAnswerId(answerId);
            voteRepository.save(vote);
        }

        return answer;
    }

//    public List<AnswerResponse> getByUserId(String userId) {
//        return answerService.getByUserId(new ObjectId(userId));
//    }

    public DataResponse addComment(Comment comment) {
        try {
            Comment _comment = commentRepository.save(comment);
            DataResponse response = new DataResponse();
            response.setStatus(1);
            return response;
        } catch (Exception e) {
            System.out.println("AnswerBusiness addComment: " + e.getMessage());
            DataResponse response = new DataResponse();
            response.setStatus(0);
            return response;
        }
    }
}
