package com.stackoverflow.nhom24.service;

import com.stackoverflow.nhom24.model.response.QuestionDetailResponse;
import com.stackoverflow.nhom24.model.response.QuestionResponse;
import com.stackoverflow.nhom24.model.response.QuestionsResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;

@Repository
public class QuestionService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<QuestionResponse> findAllQuestionAndItem(){
        LookupOperation lookupOperationUser = LookupOperation.newLookup().from("user").localField("userId").foreignField("_id").as("user");
        LookupOperation lookupOperationAnswer = LookupOperation.newLookup()
                .from("answer")
                .localField("_id")
                .foreignField("questionId")
                .as("answer");
        GroupOperation groupOperation = group("_id").sum("answer").as("answer");

        Aggregation aggregation = Aggregation.newAggregation(lookupOperationUser);
        List<QuestionResponse> results = mongoTemplate.aggregate(aggregation, "question", QuestionResponse.class).getMappedResults();
        return results;
    }

    public QuestionDetailResponse findQuestionAndItemById(String id){
        LookupOperation lookupOperationUser = LookupOperation.newLookup().from("user").localField("userId").foreignField("id").as("user");
        LookupOperation lookupOperationAnswer = LookupOperation.newLookup()
                .from("answer")
                .localField("_id")
                .foreignField("questionId")
                .as("answer");
        GroupOperation groupOperation = group("_id").sum("answer").as("answer");

        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("_id").is(id)), lookupOperationUser, lookupOperationAnswer);
        QuestionDetailResponse results = mongoTemplate.aggregate(aggregation, "question", QuestionDetailResponse.class).getUniqueMappedResult();
        return results;
    }
}
