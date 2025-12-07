package com.example.demo.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleBadRequest(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(Map.of(
                "timestamp", Instant.now().toString(),
                "status", 400,
                "error", "Bad Request",
                "message", ex.getMessage()
        ));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleConflict(IllegalStateException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                "timestamp", Instant.now().toString(),
                "status", 409,
                "error", "Conflict",
                "message", ex.getMessage()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAll(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                "timestamp", Instant.now().toString(),
                "status", 500,
                "error", "Internal Server Error",
                "message", ex.getMessage()
        ));
    }
}
