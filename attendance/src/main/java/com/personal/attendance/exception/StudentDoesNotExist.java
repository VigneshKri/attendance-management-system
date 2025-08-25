package com.personal.attendance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentDoesNotExist extends RuntimeException {
    public StudentDoesNotExist(String message) {
        super(message);
    }

}
