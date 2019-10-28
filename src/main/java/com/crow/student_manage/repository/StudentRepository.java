package com.crow.student_manage.repository;

import com.crow.student_manage.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {
    Student findStudentBySid(String sid);
    Integer deleteStudentBySid(String sid);
}
