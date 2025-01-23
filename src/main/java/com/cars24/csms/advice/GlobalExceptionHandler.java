package com.cars24.csms.advice;


import com.cars24.csms.data.res.ApiResponse;
import com.cars24.csms.exceptions.ResourceNotFoundException;
import com.cars24.csms.exceptions.UserServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException exception)
    {
        log.info("[handleValidationExceptions]");
        ApiResponse apiResponse = new ApiResponse();

        Map<String,String> errorMap=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->
        {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        log.info("[handleValidationExceptions] errorMap {}", errorMap);
        apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setSuccess(Boolean.FALSE);
        apiResponse.setMessage("Invalid credentials");
        apiResponse.setService("APPUSR"+ HttpStatus.BAD_REQUEST.value());
        apiResponse.setData(errorMap);

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<ApiResponse> handleUserServiceException(UserServiceException exception)
    {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setSuccess(Boolean.FALSE);
        apiResponse.setMessage(exception.getMessage());
        apiResponse.setService("APPUSR"+ HttpStatus.BAD_REQUEST.value());
        apiResponse.setData(null);

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setSuccess(Boolean.FALSE);
        apiResponse.setMessage(exception.getMessage());
        apiResponse.setService("APPVEH" + HttpStatus.BAD_REQUEST.value());
        apiResponse.setData(null);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

}
