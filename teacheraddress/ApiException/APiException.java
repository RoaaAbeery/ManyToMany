package com.example.teacheraddress.ApiException;

import org.springframework.data.jpa.repository.JpaRepository;

public class APiException extends RuntimeException {
    public APiException (String message){
        super(message);
    }
}
