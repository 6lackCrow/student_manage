package com.crow.student_manage.service;

import com.crow.student_manage.entity.Student;
import com.crow.student_manage.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.print.attribute.standard.Sides;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Resource
    StudentRepository studentRepository;
    public  Student add(Student student){
        return studentRepository.save(student);
    }

    public Integer deleteStudentBySid(String sid){
        Integer row = studentRepository.deleteStudentBySid(sid);
        return row;
    }

    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }

    public Student findStudentBySid(String sid){
        return studentRepository.findStudentBySid(sid);
    }

    public Student updateStudentBySid(String sid,Student student){
        String sid_tmp = sid;
        Student student_tmp = student;
        student_tmp.setSid(sid_tmp);
        return studentRepository.save(student_tmp);
    }

}
