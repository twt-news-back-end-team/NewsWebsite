package com.example.demo.utils;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class APIResponse {
    private int code;
    private String message;
    private Object result;
    public APIResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public APIResponse(int code, Object result) {
        this.code = code;
        this.result = result;
    }

    public APIResponse(String message, Object result) {
        this.message = message;
        this.result = result;
    }
    public static APIResponse error(int code, String message) {
        return new APIResponse(code, message, null);
    }

    public static APIResponse error(ErrorCode error) {
        return new APIResponse(error.getCode(), error.getMsg());
    }

    public static APIResponse error(ErrorCode error, String message){
        return new APIResponse(error.getCode(), error.getMsg() + message);
    }

    public static APIResponse success(Object result) {
        return new APIResponse(0, "Success", result);
    }
}
