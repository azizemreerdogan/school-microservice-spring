package com.example.school_service.service;

import com.example.school_service.entity.School;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SchoolService {
    public School addSchool(School school);
    public List<School> fetchSchool();
    public School fetchSchoolById(int id);

}
