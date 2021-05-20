package com.stackoverflow.nhom24.service;

import com.stackoverflow.nhom24.entity.Question;
import com.stackoverflow.nhom24.model.response.QuestionDetailResponse;
import com.stackoverflow.nhom24.model.response.QuestionResponse;
import com.stackoverflow.nhom24.model.response.QuestionsResponse;
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


    public List<QuestionResponse> findAllQuestionAndItem(long page, String tab) {
        LookupOperation lookupOperationUser = LookupOperation.newLookup().from("user").localField("userId").foreignField("_id").as("user");
        LookupOperation lookupOperationAnswer = LookupOperation.newLookup()
                .from("answer")
                .localField("_id")
                .foreignField("questionId")
                .as("answer");
        GroupOperation groupOperation = group("_id").sum("answer").as("answer");
        Aggregation aggregation = null;
        if(tab.equals("newest")){
            aggregation = Aggregation.newAggregation(Aggregation.sort(Sort.Direction.ASC, "createdOn"), lookupOperationUser, lookupOperationAnswer , Aggregation.skip((page-1)*10), Aggregation.limit(10));
        } else if(tab.equals("active")){
            aggregation = Aggregation.newAggregation(Aggregation.sort(Sort.Direction.ASC, "createdOn"), lookupOperationUser, lookupOperationAnswer , Aggregation.skip((page-1)*10), Aggregation.limit(10));
        } else if(tab.equals("unanswers")){
            aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("answers").is(0)), lookupOperationUser, lookupOperationAnswer , Aggregation.skip((page-1)*10), Aggregation.limit(10));
        }

        List<QuestionResponse> results = mongoTemplate.aggregate(aggregation, "question", QuestionResponse.class).getMappedResults();
        return results;
    }

    public int findCountOfQuestionAndItem(String tab) {
        LookupOperation lookupOperationUser = LookupOperation.newLookup().from("user").localField("userId").foreignField("_id").as("user");
        LookupOperation lookupOperationAnswer = LookupOperation.newLookup()
                .from("answer")
                .localField("_id")
                .foreignField("questionId")
                .as("answer");
        GroupOperation groupOperation = group("_id").sum("answer").as("answer");
        Aggregation aggregation = null;
        if(tab.equals("newest")){
            aggregation = Aggregation.newAggregation(Aggregation.sort(Sort.Direction.ASC, "createdOn"), lookupOperationUser, lookupOperationAnswer );
        } else if(tab.equals("active")){
            aggregation = Aggregation.newAggregation(Aggregation.sort(Sort.Direction.ASC, "createdOn"), lookupOperationUser, lookupOperationAnswer );
        } else if(tab.equals("unanswers")){
            aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("answers").is(0)), lookupOperationUser, lookupOperationAnswer );
        }

        List<QuestionResponse> results = mongoTemplate.aggregate(aggregation, "question", QuestionResponse.class).getMappedResults();
        return results.size();
    }

    public QuestionDetailResponse findQuestionAndItemById(String id){
        LookupOperation lookupOperationUser = LookupOperation.newLookup()
                .from("user")
                .localField("id")
                .foreignField("userId")
                .as("user");
//        LookupOperation lookupOperationAnswer = LookupOperation.newLookup()
//                .from("answer")
//                .localField("_id")
//                .foreignField("questionId")
//                .as("answer");
//        GroupOperation groupOperation = group("_id").sum("answer").as("answer");

        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("_id").is(id)), lookupOperationUser);
        QuestionDetailResponse results = mongoTemplate
                .aggregate(aggregation, "question",
                QuestionDetailResponse.class).getUniqueMappedResult();
        Query query = new Query();
//        query.
        return results;
    }

    public List<QuestionResponse> findQuestionAndItemByDate(Date dateStart, Date dateEnd) {
        Criteria c = new Criteria().andOperator(Criteria.where("createdOn").gte(dateStart), Criteria.where("createdOn").lte(dateEnd));
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("createdOn").gte(dateStart)));

        List<QuestionResponse> results = mongoTemplate
                .aggregate(aggregation, "question", QuestionResponse.class)
                .getMappedResults();
//        Query query = new Query();
//

//
//        query.addCriteria(c);
////        Query query = new Query(publishedDateCriteria);
//        List<QuestionResponse> results = mongoTemplate.find(query, QuestionResponse.class);
        return results;
    }

}
