package com.personal.attendance.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<?> handleException(Exception ex) {
        return ResponseEntity.status(500).body("An error occurred: " + ex.getMessage());
    }

    @ExceptionHandler(StudentExists.class)
    public ResponseEntity<?> handleStudentExistsException(StudentExists ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(StudentDoesNotExist.class)
    public ResponseEntity<?> handleStudentDoesNotExistException(StudentDoesNotExist ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

}
