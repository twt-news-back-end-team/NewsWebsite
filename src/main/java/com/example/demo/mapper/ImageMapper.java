package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImageMapper extends BaseMapper<Image> {
    @Select("select * from yr.image where hashcode=#{hashcode}")
    public List<Image> selectByHashcode(String hashcode);
}
