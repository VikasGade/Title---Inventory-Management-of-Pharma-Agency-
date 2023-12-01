package com.example.pharma.exception;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class EnterValidProduct extends RuntimeException {
    public EnterValidProduct() {
    }

    public EnterValidProduct(String message) {
        super(message);
    }
}
