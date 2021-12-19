package com.goservice.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class APIError {
    LocalDateTime timestamp;
    HttpStatus status;
    String message;
    String path;
}
