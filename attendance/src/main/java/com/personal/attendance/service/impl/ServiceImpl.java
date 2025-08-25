package com.personal.attendance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.attendance.dto.StudentDto;
import com.personal.attendance.exception.StudentDoesNotExist;
import com.personal.attendance.exception.StudentExists;
import com.personal.attendance.mapper.Mapper;
import com.personal.attendance.models.Student;
import com.personal.attendance.repository.StudentRepository;
import com.personal.attendance.service.IService;

@Service
public class ServiceImpl implements IService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void addStudent(StudentDto studentDto) {
        Student student = Mapper.mapToStudent(studentDto, new Student());
        if (studentRepository.findByParentEmail(student.getParentEmail()).isPresent()) {
            throw new StudentExists("Student with email " + student.getParentEmail() + " already exists");
        }
        studentRepository.save(student);
    }

    @Override
    public StudentDto getStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentDoesNotExist("Student with ID " + studentId + " does not exist"));
        return Mapper.mapToDto(student, new StudentDto());
    }

    @Override
    public void updateStudent(Long studentId, StudentDto studentDto) {
        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentDoesNotExist("Student with ID " + studentId + " does not exist"));
        Student updatedStudent = Mapper.mapToStudent(studentDto, existingStudent);
        studentRepository.save(updatedStudent);
    }

    @Override
    public void deleteStudent(Long studentId) {
        if (!studentRepository.findById(studentId).isPresent()) {
            throw new StudentDoesNotExist("Student with ID " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

}
