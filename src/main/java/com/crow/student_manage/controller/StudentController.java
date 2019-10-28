package com.crow.student_manage.controller;

import com.crow.student_manage.entity.Student;
import com.crow.student_manage.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/study")
public class StudentController {
    @Resource
    StudentService studentService;
    /*
    private String sid;
    private String sname;
    private Integer age;
    private String bio;*/
    @PostMapping
    public Object add(Student student){
        String sname = student.getSname();
        String sid = student.getSid();
        Integer age = student.getAge();
        String bio = student.getBio();
        String sex = student.getSex();
        if(sname!=null&&sid!=null&&age!=0&&sex!=null)
            return studentService.add(student);
        return ResponseEntity.badRequest().body("添加失败");

    }

    @DeleteMapping("/{sid}")
    public Object deleteStudentBySid(@PathVariable("sid") String sid){
        return studentService.deleteStudentBySid(sid);
    }

    @GetMapping
    public List<Student> findAllStudent(){
        return studentService.findAllStudent();
    }

    @GetMapping("/{sid}")
    public Object findStudentBySid(@PathVariable("sid") String sid){
        Student student = studentService.findStudentBySid(sid);
        if (student!=null) return student;
        return ResponseEntity.status(404);
    }
    @PutMapping("/{sid}")
    public Object updateStudentBySid(@PathVariable("sid") String sid,Student student){
        Student student_tmp = studentService.findStudentBySid(sid);
        if (student_tmp!=null)
        return studentService.updateStudentBySid(sid,student);
        return ResponseEntity.status(404);
    }


}
