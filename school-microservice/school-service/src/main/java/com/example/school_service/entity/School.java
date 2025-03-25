package com.example.school_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "school")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String schoolName;
    private String location;
    private String principalName;


    public int getId() {
        return id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getLocation() {
        return location;
    }

    public String getPrincipalName() {
        return principalName;
    }
}
