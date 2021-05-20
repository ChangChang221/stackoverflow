package com.stackoverflow.nhom24.repository;

import com.stackoverflow.nhom24.entity.Answer;
import com.stackoverflow.nhom24.entity.Question;
import com.stackoverflow.nhom24.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<Question, ObjectId> {
}
