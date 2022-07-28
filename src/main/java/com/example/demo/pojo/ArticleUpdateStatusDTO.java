package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleUpdateStatusDTO {
    @NonNull
    private Integer id;
    @NonNull
    private Integer status;
}
