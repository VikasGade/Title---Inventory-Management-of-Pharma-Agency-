package com.example.pharma.exception;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ResourceNotFoundException extends RuntimeException{

    String user;
    Long id;

    public ResourceNotFoundException(String user,Long id) {
        super(String.format("%s not found with %s"));
        this.user=user;
        this.id=id;
    }

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
