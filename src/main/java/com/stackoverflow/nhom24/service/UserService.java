package com.stackoverflow.nhom24.service;

import com.stackoverflow.nhom24.model.response.AnswerResponse;
import com.stackoverflow.nhom24.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<UserResponse> getAll(){
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.skip(0L));
        List<UserResponse> results = mongoTemplate.aggregate(aggregation, "user", UserResponse.class).getMappedResults();
        return results;
    }
}
