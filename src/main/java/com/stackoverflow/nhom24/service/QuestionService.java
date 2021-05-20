package com.stackoverflow.nhom24.service;

import com.stackoverflow.nhom24.entity.Question;
import com.stackoverflow.nhom24.model.response.AnswerResponse;
import com.stackoverflow.nhom24.model.response.QuestionDetailResponse;
import com.stackoverflow.nhom24.model.response.QuestionResponse;
import com.stackoverflow.nhom24.model.response.QuestionsResponse;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;

@Repository
public class QuestionService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @DateTimeFormat(pattern = "yyyy-mm-ddThh:mm:ss.SSSZ")
    public List<QuestionResponse> findAllQuestionAndItem(long page, String tab) {
        try {

            LookupOperation lookupOperationUser = LookupOperation.newLookup().from("user").localField("userId").foreignField("_id").as("user");
            LookupOperation lookupOperationAnswer = LookupOperation.newLookup()
                    .from("answer")
                    .localField("_id")
                    .foreignField("questionId")
                    .as("answer");
            GroupOperation groupOperation = group("_id").sum("answer").as("answer");
            Aggregation aggregation = null;
            if (tab.equals("newest")) {
                aggregation = Aggregation.newAggregation(Aggregation.sort(Sort.Direction.ASC, "createdOn"), lookupOperationUser, lookupOperationAnswer, Aggregation.skip((page - 1) * 15), Aggregation.limit(15));
            } else if (tab.equals("active")) {
                aggregation = Aggregation.newAggregation(Aggregation.sort(Sort.Direction.ASC, "createdOn"), lookupOperationUser, lookupOperationAnswer, Aggregation.skip((page - 1) * 15), Aggregation.limit(15));
            } else if (tab.equals("unanswers")) {
                aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("answers").is(0)), lookupOperationUser, lookupOperationAnswer, Aggregation.skip((page - 1) * 15), Aggregation.limit(15));
            }

            List<QuestionResponse> results = mongoTemplate.aggregate(aggregation, "question", QuestionResponse.class).getMappedResults();
            return results;
        } catch (Exception e) {
            System.out.print("error :" + e.getMessage() + "\n");
            return List.of();
        }

    }

    public int findCountOfQuestionAndItem(String tab) {
        try {
            LookupOperation lookupOperationUser = LookupOperation.newLookup().from("user").localField("userId").foreignField("_id").as("user");
            LookupOperation lookupOperationAnswer = LookupOperation.newLookup()
                    .from("answer")
                    .localField("_id")
                    .foreignField("questionId")
                    .as("answer");
            GroupOperation groupOperation = group("_id").sum("answer").as("answer");
            Aggregation aggregation = null;
            if (tab.equals("newest")) {
                aggregation = Aggregation.newAggregation(Aggregation.sort(Sort.Direction.ASC, "createdOn"), lookupOperationUser, lookupOperationAnswer);
            } else if (tab.equals("active")) {
                aggregation = Aggregation.newAggregation(Aggregation.sort(Sort.Direction.ASC, "createdOn"), lookupOperationUser, lookupOperationAnswer);
            } else if (tab.equals("unanswers")) {
                aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("answers").is(0)), lookupOperationUser, lookupOperationAnswer);
            }

            List<QuestionResponse> results = mongoTemplate.aggregate(aggregation, "question", QuestionResponse.class).getMappedResults();
            return results.size();
        } catch (Exception e) {
            return 0;
        }
    }


    public QuestionDetailResponse findQuestionAndItemById(String id) {
        try {
            System.out.println("id:" + id);
            ObjectId objId = new ObjectId(id);
            LookupOperation lookupOperationUser = LookupOperation.newLookup().from("user").localField("id").foreignField("userId").as("user");
//        LookupOperation lookupOperationAnswer = LookupOperation.newLookup()
//                .from("answer")
//                .localField("_id")
//                .foreignField("questionId")
//                .as("answer");
//        GroupOperation groupOperation = group("_id").sum("answer").as("answer");

            Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("_id").is(objId)), lookupOperationUser);
            QuestionDetailResponse results = mongoTemplate.aggregate(aggregation, "question", QuestionDetailResponse.class).getUniqueMappedResult();
            Query query = new Query();
//        query.
            return results;
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
            return new QuestionDetailResponse();
        }
    }

    public List<QuestionResponse> getByUserId(ObjectId userId){
        try {
            Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("userId").is(userId)));
            List<QuestionResponse> results = mongoTemplate.aggregate(aggregation, "question", QuestionResponse.class).getMappedResults();
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
