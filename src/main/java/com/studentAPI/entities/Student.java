package com.studentAPI.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.NonNull;

import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long studentid;

    @NonNull
    private String studentname;

    @NonNull
    private String studentyear;

    @NonNull
    private String studentStream;

    @Nullable
    private String studentdob;

    public Student() {
        super();
    }

    public Student(Long studentid, @NonNull String studentname, @NonNull String studentyear, @NonNull String studentStream, String studentdob) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.studentyear = studentyear;
        this.studentStream = studentStream;
        this.studentdob = studentdob;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentyear() {
        return studentyear;
    }

    public void setStudentyear(String studentyear) {
        this.studentyear = studentyear;
    }

    public String getStudentStream() {
        return studentStream;
    }

    public void setStudentStream(String studentStream) {
        this.studentStream = studentStream;
    }

    public String getStudentdob() {
        return studentdob;
    }

    public void setStudentdob(String studentdob) {
        this.studentdob = studentdob;
    }
}
