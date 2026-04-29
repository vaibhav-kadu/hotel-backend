package com.vkmaster.hotelmanagement.exception;

import com.vkmaster.hotelmanagement.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleNotFound(ResourceNotFoundException ex) {

        return new ResponseEntity<>(
                new ApiResponse<>(false, ex.getMessage(), null),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> handleBadRequest(BadRequestException ex) {

        return new ResponseEntity<>(
                new ApiResponse<>(false, ex.getMessage(), null),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneral(Exception ex, HttpServletRequest request) {

        String path = request.getRequestURI();

        //Ignoring Swagger/OpenAPI end Points
        if(path.contains("/v3/api-docs") || path.contains("/swagger")){
            throw new RuntimeException(ex); // let Spring Handel it
        }
        return new ResponseEntity<>(
                new ApiResponse<>(false, "Internal Server Error", null),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}