package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carousel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer articleId;
    private Integer imageId;
    private String title;
    private String summary;
    private Date createDate;
}
