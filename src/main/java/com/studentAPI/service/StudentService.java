package com.studentAPI.service;

import com.studentAPI.entities.Student;
import com.studentAPI.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentByStudentId(Long studentId){
        return studentRepository.findByStudentid(studentId);
    }

    public void deleteStudentByStudentId(Long studentId){

        studentRepository.deleteByStudentid(studentId);
    }

    public Student UpdateStudentByStudentId(Student student,Long studentid){
       Student newStudent = this.studentRepository.findByStudentid(studentid);
       if(newStudent.getStudentid() == studentid) {
           newStudent.setStudentname(student.getStudentname());
           newStudent.setStudentStream(student.getStudentStream());
           newStudent.setStudentyear(student.getStudentyear());
           newStudent.setStudentdob(student.getStudentdob());
           return this.studentRepository.save(newStudent);
       }
       else{
          return null;
        }



    }


}
