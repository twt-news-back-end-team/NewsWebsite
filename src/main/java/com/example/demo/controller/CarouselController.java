package com.example.demo.controller;

import com.example.demo.pojo.Carousel;
import com.example.demo.pojo.CarouselCreateDTO;
import com.example.demo.service.CarouselService;
import com.example.demo.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crs")
public class CarouselController {
    private final CarouselService carouselService;

    @Autowired
    public CarouselController(CarouselService carouselService) {
        this.carouselService = carouselService;
    }

    @PostMapping("/create")
    public APIResponse crsCreate(@RequestBody CarouselCreateDTO carouselCreateDTO) {
        return carouselService.crsCreate(carouselCreateDTO);
    }

    @PostMapping("/delete")
    public APIResponse crsDelete(@RequestParam("id") Integer id) {
        return carouselService.crsDelete(id);
    }

    @PostMapping("/update")
    public APIResponse crsUpdate(@RequestBody Carousel carousel) {
        return carouselService.crsUpdate(carousel);
    }

    @GetMapping("/select/{id}")
    public APIResponse crsSelectById(@PathVariable("id") Integer id) {
        return carouselService.crsSelectById(id);
    }

    @GetMapping("/select")
    public APIResponse crsSelect() {
        return carouselService.crsSelect();
    }
}
