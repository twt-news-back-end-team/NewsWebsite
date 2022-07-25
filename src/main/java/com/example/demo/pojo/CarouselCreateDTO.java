package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class CarouselCreateDTO {
    @NonNull
    private Integer articleId;
    @NonNull
    private Integer imageId;
    @NonNull
    private String title;
    @NonNull
    private String summary;
}
