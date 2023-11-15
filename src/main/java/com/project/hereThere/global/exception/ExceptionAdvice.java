package com.project.hereThere.global.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @Getter
    @Builder
    @RequiredArgsConstructor
    public record ErrorResponse(int status, String massage){
    }

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<ErrorResponse> handleException(BusinessException e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(e.getError().getStatus().value())
                .massage(e.getError().getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, e.getError().getStatus());
    }
}
