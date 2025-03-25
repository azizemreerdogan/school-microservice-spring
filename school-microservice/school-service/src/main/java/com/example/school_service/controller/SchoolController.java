package com.example.school_service.controller;


import com.example.school_service.entity.School;
import com.example.school_service.service.SchoolService;
import com.example.school_service.service.SchoolServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/school")
@CrossOrigin("*")
@RestController
public class SchoolController {
    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }

    @PostMapping
    public School addSchool(@RequestBody School school){
        return schoolService.addSchool(school);
    }

    @GetMapping
    public List<School> fetchAll(){
        return schoolService.fetchSchool();
    }

    @GetMapping("/{id}")
    public School fetchById(@PathVariable int id){
        return schoolService.fetchSchoolById(id);
    }
}
