package com.stackoverflow.nhom24.business;

import com.stackoverflow.nhom24.business.base.BaseBusiness;
import com.stackoverflow.nhom24.entity.Answer;
import com.stackoverflow.nhom24.entity.Vote;
import com.stackoverflow.nhom24.model.response.AnswerResponse;
import com.stackoverflow.nhom24.repository.AnswerRepository;
import com.stackoverflow.nhom24.repository.UserRepository;
import com.stackoverflow.nhom24.repository.VoteRepository;
import com.stackoverflow.nhom24.service.AnswerService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class AnswerBusiness extends BaseBusiness {
    private final AnswerRepository answerRepository;

    private final UserRepository userRepository;

    private final VoteRepository voteRepository;

    private final AnswerService answerService;

    public void saveAnswer(Answer answer){
        answerRepository.save(answer);
    }

    public List<AnswerResponse> getByQuestionId(ObjectId questionId){
        List<AnswerResponse> responses = answerService.getByQuestionId(questionId);
//        for (Answer el: answers){
//            AnswerResponse answer = mapper.map(el, AnswerResponse.class);
//            User user = userRepository.findById(el.getUserId().toString()).get();
//            answer.setUser(mapper.map(user, UserResponse.class));
//        }
        System.out.println(responses);
        return responses;
    }

    public Answer upVote(ObjectId id, ObjectId userId){
        Answer answer = answerRepository.findById(id).get();
        Vote vote = new Vote();
        vote.setStatus(true);
        vote.setUserId(userId);
//        voteRepository.save(vote);
        answer.setVotes(new ArrayList<>());
        answer.addVote(id);
        answer.setScore(answer.getScore() + 2);
        answer = answerRepository.save(answer);
        return answer;
    }

    public List<AnswerResponse> getByUserId(String userId){
        return answerService.getByUserId(new ObjectId(userId));
    }
}
