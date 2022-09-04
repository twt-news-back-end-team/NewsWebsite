package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Integer id;
    private String text;
    private String title;
    private String origin;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date releaseTime;
    private Integer status;
    private String contributorName;
    private String reviewerName;
    private Integer contributorId;
    private Integer coverImageId;
    private Integer bannerImageId;
    private Integer categoryId;
    private Integer viewsNumber;
}
