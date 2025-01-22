package com.cars24.csms.advice;

import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.exceptions.UserServiceException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

//    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException exception)
    {
//        log.info("[handleValidationExceptions]");
        ApiResponse apiResponse=new ApiResponse();



            log.info("[handleValidationExceptions]");
        Map<String,String> errorMap=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->
        {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });

//         apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());;
        apiResponse.setSuccess(false);
        apiResponse.setMessage("User already exists");
        apiResponse.setService("App user - "+HttpStatus.BAD_REQUEST.value());
        apiResponse.setData(errorMap);
        return ResponseEntity.badRequest().body(apiResponse);

    }


    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<ApiResponse> handleUserServiceException(UserServiceException exception)
    {
        ApiResponse apiResponse=new ApiResponse();

            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());;
            apiResponse.setSuccess(false);
            apiResponse.setMessage(exception.getMessage());

            apiResponse.setService("App user - "+HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(apiResponse);

    }


}