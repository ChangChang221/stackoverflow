package com.stackoverflow.nhom24.service;

import com.stackoverflow.nhom24.entity.Answer;
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

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;

@Repository
public class AnswerService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<AnswerResponse> getByQuestionId(String questionId){
        LookupOperation lookupOperationUser = LookupOperation.newLookup()
                .from("user")
                .localField("id")
                .foreignField("userId")
                .as("user");

        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("questionId").is(new ObjectId(questionId))), lookupOperationUser);
        List<AnswerResponse> results = mongoTemplate.aggregate(aggregation, "answer", AnswerResponse.class).getMappedResults();
        return results;
    }
}
