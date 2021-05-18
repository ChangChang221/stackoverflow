package com.stackoverflow.nhom24.service;

import com.stackoverflow.nhom24.model.response.UserResponse;
import com.stackoverflow.nhom24.model.response.VoteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VoteService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<VoteResponse> getAll(){
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.skip(0L));
        List<VoteResponse> results = mongoTemplate.aggregate(aggregation, "vote", VoteResponse.class).getMappedResults();
        return results;
    }
}
