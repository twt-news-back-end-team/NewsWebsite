package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImageMapper extends BaseMapper<Image> {
    @Select("select * from image where hashcode=#{hashcode}")
    List<Image> selectByHashcode(String hashcode);
    @Select("select * from image where image_uploader_id =#{imageUploaderId}")
    List<Image> selectByImageUploaderId(String imageUploaderId);
    @Select("select * from image where image_url=#{imageUrl}")
    List<Image> selectByImageUrl(String imageUrl);
}
