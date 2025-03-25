package com.example.student_service.repository;

import com.example.student_service.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


//MongoDb expects id as String
@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

}
