package com.lauro.sifyflixapi.controlleradvice;

import com.lauro.sifyflixapi.exception.RecordNotFoundException;
import com.lauro.sifyflixapi.controller.spaceship.SpaceshipRestController;
import com.lauro.sifyflixapi.dto.ApiMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@RestControllerAdvice(assignableTypes = SpaceshipRestController.class)
public class SpaceShipControllerAdvice {

    @ExceptionHandler({RecordNotFoundException.class})
    public ResponseEntity<ApiMessage> handleRecordNotFoundException(RecordNotFoundException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(ApiMessage.builder()
                .httpStatus(ex.getHttpStatus())
                .message(ex.getMessage())
                .build());
    }

    @ExceptionHandler({HandlerMethodValidationException.class})
    public ResponseEntity<ApiMessage> handleMethodValidationException(HandlerMethodValidationException ex) {
        return ResponseEntity.badRequest().body(ApiMessage.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .build());
    }
}
