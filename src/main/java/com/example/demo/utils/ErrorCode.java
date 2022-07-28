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
    STRING_LENGTH_ERROR(2001, "String Length Error"),
    CAROUSEL_DATE_ERROR(2002, "Carousel Create Date Error"),
    STATUS_ERROR(2003, "Status Not in True Range"),
    ARTICLE_DATE_ERROR(2004, "Article Release Date Error"),
    Tag_EXIST_ERROR(3001,"Tag exists"),
    Tag_NOT_EXIST_ERROR(3002,"Tag not exists");
    private int code;
    private String msg;
}
