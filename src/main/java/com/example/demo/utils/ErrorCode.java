package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorCode {
    /*
     *
     */
    OK(0,"success"),
    PASSWORD_ERROR(1001,"Password Error"),
    MD5_ERROR(1002,"MD5 Error"),
    LOGIN_ERROR(1003,"Login Error"),
    IMAGE_URL_ERROR(1004,"Image Url Error"),
    IMAGE_ID_ERROR(1005,"Image Id Error");
    private int code;
    private String msg;
}
