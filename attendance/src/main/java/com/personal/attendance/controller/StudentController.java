package com.personal.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.personal.attendance.dto.StudentDto;
import com.personal.attendance.service.IService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/attendance")
public class StudentController {
    @Autowired
    private IService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<HttpStatus> addStudent(@RequestBody StudentDto studentDto) {
        studentService.addStudent(studentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getStudent/{studentId}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long studentId) {
        StudentDto studentDto = studentService.getStudent(studentId);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    @PutMapping("/updateStudent/{studentId}")
    public ResponseEntity<HttpStatus> updateStudent(@PathVariable Long studentId, @RequestBody StudentDto studentDto) {
        studentService.updateStudent(studentId, studentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
