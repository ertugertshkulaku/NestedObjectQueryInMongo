package com.example.NestedObjectFilterMongoDB.repository;

import com.example.NestedObjectFilterMongoDB.model.University;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityMongoRepository extends MongoRepository<University, String> {
    University findUniversityById(String universityId);
}
