package com.example.student_service.service;

import com.example.student_service.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    public ResponseEntity<?> createStudent(Student student);
    public ResponseEntity<?> fetchStudentById(String id);
    public ResponseEntity<?> fetchStudents();
}
