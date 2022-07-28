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
    IMAGE_ID_ERROR(1005,"Image Id Error"),
    IMAGE_DELETE_ERROR(1006,"Image Delete Error"),
    Tag_EXIST_ERROR(3001,"Tag exists"),
    Tag_NOT_EXIST_ERROR(3002,"Tag not exists");
    private int code;
    private String msg;
}
