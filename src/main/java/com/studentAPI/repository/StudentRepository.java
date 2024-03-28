package com.studentAPI.repository;

import com.studentAPI.entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    public List<Student> findAll();
    public Student findByStudentid(Long studentId);
    @Transactional
    public void deleteByStudentid(Long studentId);

}
