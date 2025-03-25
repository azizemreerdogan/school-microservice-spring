package com.example.student_service.dto;

import com.example.student_service.dto.School;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {
    private String id;
    private String name;
    private int age;
    private String gender;
    private School school;

    public StudentDTO(String id, String name, int age, String gender, School school) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.school = school;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public School getSchool() {
        return school;
    }
}
