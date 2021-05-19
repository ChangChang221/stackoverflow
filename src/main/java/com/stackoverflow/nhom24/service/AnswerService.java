package com.stackoverflow.nhom24.service;

import com.stackoverflow.nhom24.entity.Answer;
import com.stackoverflow.nhom24.entity.User;
import com.stackoverflow.nhom24.model.response.AnswerResponse;
import com.stackoverflow.nhom24.model.response.QuestionDetailResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;

@Repository
public class AnswerService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<AnswerResponse> getByQuestionId(ObjectId questionId) {
        try {
            Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("questionId").is(questionId)));
            List<AnswerResponse> results = mongoTemplate.aggregate(aggregation, "answer", AnswerResponse.class).getMappedResults()
                    .stream().map(answerResponse -> {
                        Aggregation _aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("_id").is(answerResponse.getUserId())));
                        User user = mongoTemplate.aggregate(_aggregation, "user", User.class).getUniqueMappedResult();
                        answerResponse.setUser(user);
                        return answerResponse;
                    }).collect(Collectors.toList());
            return results;
        } catch (Exception e) {
            return List.of();
        }
    }

    public List<AnswerResponse> getByUserId(ObjectId userId){
        try {
            Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("userId").is(userId)));
            List<AnswerResponse> results = mongoTemplate.aggregate(aggregation, "answer", AnswerResponse.class).getMappedResults();
//                    .stream().map(answerResponse -> {
//                        Aggregation _aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("_id").is(answerResponse.getUserId())));
//                        User user = mongoTemplate.aggregate(_aggregation, "user", User.class).getUniqueMappedResult();
//                        answerResponse.setUser(user);
//                        return answerResponse;
//                    }).collect(Collectors.toList());
            return results;
        } catch (Exception e) {
            return List.of();
        }
    }
}
