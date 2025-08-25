package com.personal.attendance.mapper;

import com.personal.attendance.dto.StudentDto;
import com.personal.attendance.models.Student;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Mapper {
    public static StudentDto mapToDto(Student student, StudentDto studentDto) {
        studentDto.setStudentName(student.getStudentName());
        studentDto.setParentPhoneNumber(student.getParentPhoneNumber());
        studentDto.setParentEmail(student.getParentEmail());
        return studentDto;
    }

    public static Student mapToStudent(StudentDto studentDto, Student student) {
        student.setStudentName(studentDto.getStudentName());
        student.setParentPhoneNumber(studentDto.getParentPhoneNumber());
        student.setParentEmail(studentDto.getParentEmail());
        return student;
    }
}
