package com.stackoverflow.nhom24.service;

import com.stackoverflow.nhom24.model.response.AnswerResponse;
import com.stackoverflow.nhom24.model.response.UserResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public UserResponse getById(String id){
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("_id").is(new ObjectId(id))));
        UserResponse results = mongoTemplate.aggregate(aggregation, "user", UserResponse.class).getUniqueMappedResult();
        return results;
    }
}
