package com.example.school_service.service;

import com.example.school_service.entity.School;
import com.example.school_service.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService{
    private SchoolRepository schoolRepository;

    @Autowired
    public SchoolServiceImpl(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;
    }

    @Override
    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public List<School> fetchSchool() {
        return schoolRepository.findAll();
    }

    @Override
    public School fetchSchoolById(int id) {
        return schoolRepository.findById(id).orElse(null);
    }



}
