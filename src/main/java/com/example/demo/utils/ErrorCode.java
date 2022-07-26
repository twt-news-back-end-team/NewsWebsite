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
    STRING_LENGTH_ERROR(2001, "String Length Error"),
    CAROUSEL_DATE_ERROR(2002, "Carousel Create Date Error"),
    STATUS_ERROR(2003, "Status Not in True Range"),
    ARTICLE_DATE_ERROR(2004, "Article Release Date Error");
    private int code;
    private String msg;
}
