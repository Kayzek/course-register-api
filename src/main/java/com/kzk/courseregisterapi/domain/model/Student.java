package com.kzk.courseregisterapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String courseCode;

    public Student(String name, String lastName, String email, String courseCode) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.courseCode = courseCode;
    }
}
