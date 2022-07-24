package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.ImageMapper;
import com.example.demo.pojo.Image;
import com.example.demo.service.ImageService;
import com.example.demo.utils.APIResponse;
import com.example.demo.utils.ErrorCode;
import com.example.demo.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {
    @Autowired
    private ImageMapper imageMapper;
//    private final static String imgPath = "/root/img";
    private final static String imgPath = "E:\\mp4";
    @Override
    public APIResponse uploadImage(MultipartFile img, HttpSession session) {
        //获得文件名
/*
        String userId =(String) session.getAttribute("userId");
        if(userId.isEmpty()) {
            return APIResponse.error(ErrorCode.LOGIN_ERROR);
        }
*/
        Random random = new Random();
        String imgName = img.getOriginalFilename();
        String suffixName = imgName.substring(imgName.lastIndexOf("."));
        imgName = random.nextInt(1000) + suffixName;
        String path = imgPath + imgName;
        try {
            //获得哈希码
            String hashcode = MD5Util.md5HashCode(img.getInputStream());
            List<Image> imageList = imageMapper.selectByHashcode(hashcode);
            if(imageList.size()!=0) {
                path = imageList.get(0).getImageUrl();
            }
            else {
                img.transferTo(new File(path));
            }
            this.save(new Image(null,path,null,hashcode));
        } catch (IOException e) {
            return APIResponse.error(ErrorCode.MD5_ERROR);
        }
        return APIResponse.success(path);
    }

    @Override
    public APIResponse getImageByImageUploaderId(HttpSession session) {
        String userId = (String)session.getAttribute("userId");
        if(userId.isEmpty()) {
            return APIResponse.error(ErrorCode.LOGIN_ERROR);
        }
        List<Image> imageList = imageMapper.selectByImageUploaderId(userId);
        List<String> urlList = new ArrayList<>();
        for(Image image : imageList) {
            urlList.add(image.getImageUrl());
        }
        return APIResponse.success(urlList);
    }

}
