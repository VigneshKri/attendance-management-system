package com.personal.attendance.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentExists extends RuntimeException {
    public StudentExists(String message) {
        super(message);
    }

}
