package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.Image;
import com.example.demo.utils.APIResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

public interface ImageService extends IService<Image> {
    public APIResponse uploadImage(MultipartFile img, HttpSession session);
}
