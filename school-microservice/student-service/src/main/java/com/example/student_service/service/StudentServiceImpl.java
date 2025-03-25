package com.example.student_service.service;

import com.example.student_service.dto.School;
import com.example.student_service.dto.StudentDTO;
import com.example.student_service.entity.Student;
import com.example.student_service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    StudentRepository studentRepository;
    RestTemplate restTemplate;


    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, RestTemplate restTemplate){
        this.studentRepository = studentRepository;
        this.restTemplate = restTemplate;
    }
    @Override
    public ResponseEntity<?> createStudent(Student student) {
        try{
            return new ResponseEntity<Student>(studentRepository.save(student),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //So we want Student's detailed information including School info and not for the
    //General student search because of performance issues
    @Override
    public ResponseEntity<?> fetchStudentById(String id) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if(existingStudent.isPresent()){
            School school = restTemplate.getForObject("http://SCHOOL-SERVICE/school/" + existingStudent.get().getSchoolId().toString(), School.class);
            StudentDTO studentDTO = new StudentDTO(
                    existingStudent.get().getId(),
                    existingStudent.get().getName(),
                    existingStudent.get().getAge(),
                    existingStudent.get().getGender(),
                    school
            );

            return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Student Found",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> fetchStudents() {
        List<Student> students = studentRepository.findAll();
        if(!students.isEmpty()){
            return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No students found",HttpStatus.NOT_FOUND);
        }
    }
}
