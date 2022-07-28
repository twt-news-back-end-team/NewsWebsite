package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
