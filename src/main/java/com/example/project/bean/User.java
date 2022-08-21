package com.example.project.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String passWord;
    private String student_no;
    private String institute;
    private String grade;
    private String classes;
    private String userName;


    public User(String student_no, String institute, String grade, String classes, String userName) {
        this.student_no= student_no;
        this.institute= institute;
        this.grade= grade;
        this.classes= classes;
        this.userName= userName;


    }
}
