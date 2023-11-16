package com.project.hereThere.global.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BaseResponse {
    private HttpStatus httpStatus;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public BaseResponse(HttpStatus httpStatus, String message, Object data) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }

    public void of(HttpStatus status, String message, Object data){
        this.httpStatus = status;
        this.message = message;
        this.data = data;
    }
    public void of(HttpStatus status, String message){
        this.httpStatus = status;
        this.message = message;
    }
}
