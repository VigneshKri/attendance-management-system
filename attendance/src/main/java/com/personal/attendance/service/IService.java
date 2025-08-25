package com.personal.attendance.service;

import com.personal.attendance.dto.StudentDto;

public interface IService {
    void addStudent(StudentDto studentDto);
    StudentDto getStudent(Long studentId);
    void updateStudent(Long studentId, StudentDto studentDto);
    void deleteStudent(Long studentId);
}
