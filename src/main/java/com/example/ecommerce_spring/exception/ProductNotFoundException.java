package com.example.ecommerce_spring.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}


//Why extend RuntimeException?

//Marks it an unchecked exception. Callers are not forced to declare or catch it.
