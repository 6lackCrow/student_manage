package com.crow.student_manage.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "sid")
})
public class Student {
    @Id
    @Column(length = 50)
    private String sid;
    private String sname;
    private String sex;
    private Integer age;
    private String bio;

}
