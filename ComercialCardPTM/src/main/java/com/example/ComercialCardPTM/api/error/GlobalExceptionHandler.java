package com.example.ComercialCardPTM.api.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(NotFoundException ex, HttpServletRequest req) {
        var err = new ApiError();
        err.status = 404;
        err.error = "Not Found";
        err.message = ex.getMessage();
        err.path = req.getRequestURI();
        return ResponseEntity.status(404).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req) {
        var err = new ApiError();
        err.status = 400;
        err.error = "Bad Request";
        err.message = ex.getBindingResult().getAllErrors().stream()
                .findFirst().map(e -> e.getDefaultMessage()).orElse("Validation error");
        err.path = req.getRequestURI();
        return ResponseEntity.badRequest().body(err);
    }
}
