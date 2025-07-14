package com.example.ecommerce_spring.exception;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@NoArgsConstructor
public class ErrResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;

    public ErrResponse(int status, String message, LocalDateTime timestamp) {

        this.status = status;
        this.message  = message;
        this.timestamp = timestamp;
    }
}
