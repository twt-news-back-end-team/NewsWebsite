package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

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
    private List<String> tagNameList;
    private Integer coverImageId;
    private Integer bannerImageId;
    private Integer categoryId;
}
