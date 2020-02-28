package com.example.basicspringboot.dao;

import com.example.basicspringboot.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {
    int insertNewStudent(UUID studentId, Student student);
    Student selectStudentById(UUID studentId);
    List<Student> seclectAllStudents();
    int updateStudentById(UUID studentId, Student studentUpdate);
    int deleteStudentById(UUID studentId);
}
