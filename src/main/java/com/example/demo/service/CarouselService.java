package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.Carousel;
import com.example.demo.pojo.CarouselCreateDTO;
import com.example.demo.utils.APIResponse;

public interface CarouselService extends IService<Carousel> {
    APIResponse crsCreate(CarouselCreateDTO carouselCreateDTO);

    APIResponse crsDelete(Integer id);

    APIResponse crsUpdate(Carousel carousel);

    APIResponse crsSelectById(Integer id);

    APIResponse crsSelect();
}
