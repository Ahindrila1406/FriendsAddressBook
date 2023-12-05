package com.assignment.addressbook.exception;

import com.assignment.addressbook.model.CustomErrorModel;
import com.assignment.addressbook.model.CustomResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomResponseModel> resourceNotFoundException(CustomException e)
    {
        CustomErrorModel customErrorModel = new CustomErrorModel("500" , e.getLocalizedMessage(), LocalDateTime.now());
        return new ResponseEntity<>(new CustomResponseModel(null, customErrorModel), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
