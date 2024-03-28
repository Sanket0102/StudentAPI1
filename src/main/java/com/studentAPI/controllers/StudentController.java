package com.studentAPI.controllers;

import com.studentAPI.entities.Student;
import com.studentAPI.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/student")
@ResponseBody
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    ResponseEntity<Student> createStudent(@RequestBody Student student){
        if(this.studentService.createStudent(student) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

       return ResponseEntity.of(Optional.of(this.studentService.createStudent(student)));
    }

    @GetMapping("/read/{studentid}")
    ResponseEntity<Student> readStudentById(@PathVariable("studentid") Long studentId){
        if(this.studentService.getStudentByStudentId(studentId)== null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(this.studentService.getStudentByStudentId(studentId)));
    }

    @GetMapping("/read")
    ResponseEntity<List<Student>> readAllStudent(){
        if(this.studentService.getAllStudent().size() <= 0) {
           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(this.studentService.getAllStudent()));
    }

    @DeleteMapping("/delete/{studentid}")
    ResponseEntity<Void> deleteStudent(@PathVariable("studentid") Long studentid){
        if(this.studentService.getAllStudent() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{studentid}")
    ResponseEntity<Student> updateStudent(@PathVariable("studentid")Long studentid,@RequestBody Student student){
        if(this.studentService.UpdateStudentByStudentId(student,studentid) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(this.studentService.UpdateStudentByStudentId(student,studentid)));
    }


}
