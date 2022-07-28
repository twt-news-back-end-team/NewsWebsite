package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCreateDTO {
    @NonNull
    private String text;
    @NonNull
    private String title;
    @NonNull
    private String origin;
    @NonNull
    private Integer status;
    @NonNull
    private String contributorName;
    @NonNull
    private String reviewerName;
}
