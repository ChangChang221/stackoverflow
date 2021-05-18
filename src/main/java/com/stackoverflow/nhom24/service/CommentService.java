package com.stackoverflow.nhom24.service;

import com.stackoverflow.nhom24.model.response.CommentResponse;
import com.stackoverflow.nhom24.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<CommentResponse> getAll(){
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.skip(0L));
        List<CommentResponse> results = mongoTemplate.aggregate(aggregation, "comment", CommentResponse.class).getMappedResults();
        return results;
    }
}
