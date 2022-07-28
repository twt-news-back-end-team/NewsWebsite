package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.CarouselMapper;
import com.example.demo.pojo.Carousel;
import com.example.demo.pojo.CarouselCreateDTO;
import com.example.demo.service.CarouselService;
import com.example.demo.utils.APIResponse;
import com.example.demo.utils.ErrorCode;
import com.example.demo.utils.LengthCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {
    private final CarouselMapper carouselMapper;

    @Autowired
    public CarouselServiceImpl(CarouselMapper carouselMapper) {
        this.carouselMapper = carouselMapper;
    }

    @Override
    @Transactional
    public APIResponse crsCreate(CarouselCreateDTO carouselCreateDTO) {
        if(LengthCheck.check(carouselCreateDTO.getSummary()) || LengthCheck.check(carouselCreateDTO.getTitle())) {
            return APIResponse.error(ErrorCode.STRING_LENGTH_ERROR);
        }

        Carousel carousel = new Carousel();
        carousel.setSummary(carouselCreateDTO.getSummary());
        carousel.setTitle(carouselCreateDTO.getTitle());
        carousel.setArticleId(carouselCreateDTO.getArticleId());
        carousel.setImageId(carouselCreateDTO.getImageId());
        carousel.setCreateDate(new Date());

        carouselMapper.insert(carousel);
        return APIResponse.success(carousel);
    }

    @Override
    @Transactional
    public APIResponse crsDelete(Integer id) {
        carouselMapper.deleteById(id);
        return APIResponse.error(ErrorCode.OK);
    }

    @Override
    @Transactional
    public APIResponse crsUpdate(Carousel carousel) {
        if(LengthCheck.check(carousel.getSummary()) || LengthCheck.check(carousel.getTitle())) {
            return APIResponse.error(ErrorCode.STRING_LENGTH_ERROR);
        }
        Carousel preCarousel = carouselMapper.selectById(carousel.getId());
        if (!preCarousel.getCreateDate().equals(carousel.getCreateDate())) {
            return APIResponse.error(ErrorCode.CAROUSEL_DATE_ERROR);
        }

        carouselMapper.updateById(carousel);
        return APIResponse.error(ErrorCode.OK);
    }

    @Override
    public APIResponse crsSelectById(Integer id) {
        return APIResponse.success(carouselMapper.selectById(id));
    }

    @Override
    public APIResponse crsSelect() {
        return APIResponse.success(carouselMapper.selectList(null));
    }
}
