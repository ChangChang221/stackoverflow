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
import java.util.stream.Collectors;

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

    public List<AnswerResponse> getByQuestionId(ObjectId questionId) {
        List<AnswerResponse> responses = answerService.getAnswerResponsesByQuestionId(questionId);
        System.out.println(responses);
        return responses;
    }

    public Integer upVote(ObjectId answerId, ObjectId userId, Boolean status) {
        try {
            Answer answer = answerRepository.findById(answerId).get();
            VoteResponse voteResponse = answerService.getVotesByAnswerIdAndUserId(answerId, userId);
            System.out.println("voteResponse: " + voteResponse);
            if (voteResponse != null) {
                if (voteResponse.getStatus() == status) {
                    voteRepository.deleteById(voteResponse.getId());
                } else {
                    Vote vote = new Vote();
                    vote.setStatus(status);
                    vote.setAnswerId(answerId);
                    vote.setUserId(userId);
                    vote.setId(voteResponse.getId());
                    voteRepository.save(vote);
                }
            } else {
                Vote vote = new Vote();
                vote.setStatus(status);
                vote.setUserId(userId);
                vote.setAnswerId(answerId);
                voteRepository.save(vote);
            }
            answerService.updateAnswerScore(answerId);
            return 1;
        } catch (Exception e) {
            return 0;
        }

    }

//    public List<AnswerResponse> getByUserId(String userId) {
//        return answerService.getByUserId(new ObjectId(userId));
//    }

    public DataResponse addComment(Comment comment) {
        try {
            commentRepository.save(comment);
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
